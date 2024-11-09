import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class W9_8 extends JFrame {
    JLabel lbtext = new JLabel();
    JLabel lbscore = new JLabel();
    JTextField tfscore = new JTextField();
    JPanel ptop = new JPanel();
    JPanel pgame = new JPanel();
    JPanel psount = new JPanel();

    JLabel lbbirdposition = new JLabel();
    JLabel lbshoot = new JLabel();
    JLabel lbangle = new JLabel();
    JButton ok = new JButton("OK");

    draw gamePanel;

    W9_8() {

        setLayout(null);

        lbscore.setText("SCORE");
        lbscore.setBounds(550, 10, 50, 30);
        tfscore.setBounds(600, 10, 100, 30);
        tfscore.setEditable(false); 
        
        lbtext.setText("SCENE 1: At Tokyo");
        lbtext.setBounds(10, 10, 200, 30);

        ptop.setLayout(null);
        ptop.setBounds(10, 10, 1000, 100);
        ptop.add(lbtext);
        ptop.add(lbscore);
        ptop.add(tfscore);

        
        URL linkimgab = this.getClass().getResource("ag.png");
        Image imgab = new ImageIcon(linkimgab).getImage();
        URL linkimpig = this.getClass().getResource("pig.png");
        Image imgpig = new ImageIcon(linkimpig).getImage();
        URL linkbg = this.getClass().getResource("tokyo.png");
        Image imgbg = new ImageIcon(linkbg).getImage();


        add(ptop);

        gamePanel = new draw(imgab, imgpig, imgbg, tfscore);
        gamePanel.setBounds(20, 120, 960, 400);
        add(gamePanel);

        lbbirdposition.setText("Bird Position in y-axis:");
        lbshoot.setText("Shooting speed:");
        lbangle.setText("Angle:");

        psount.setLayout(null);
        psount.setBounds(10, 530, 980, 200);

        lbbirdposition.setBounds(10, 10, 150, 30);
        lbshoot.setBounds(10, 50, 150, 30);
        lbangle.setBounds(10, 90, 100, 30);
        JTextField tfbird = new JTextField();
        JTextField tfshoot = new JTextField();
        JTextField tfangle = new JTextField();
        tfbird.setBounds(200, 10, 100, 30);
        tfshoot.setBounds(200, 50, 100, 30);
        tfangle.setBounds(200, 90, 100, 30);
        ok.setBounds(400, 150, 200, 40);
        ok.addActionListener(new Listener(gamePanel, tfscore, tfbird, tfshoot, tfangle));


        psount.add(lbbirdposition);
        psount.add(tfbird);
        psount.add(ok);
        psount.add(lbshoot);
        psount.add(tfshoot);
        psount.add(lbangle);
        psount.add(tfangle);


        add(psount);
    }

    static class draw extends JPanel {
        Image imgab;
        Image imgpig;
        Image imgbg;
        Timer time;
        int x = 0;
        int y = 350;
        int xpig; 
        int ypig; 
        int xSpeed = 0;
        int ySpeed = 0;
        int score = 0; 
        JTextField tfscore; 

        draw(Image imgab, Image imgpig, Image imgbg, JTextField tfscore) {
            this.imgab = imgab;
            this.imgpig = imgpig;
            this.imgbg = imgbg;
            this.tfscore = tfscore;

            this.xpig = 800;
            this.ypig = 300; 

            time = new Timer(30, e -> {

                x += xSpeed;
                y -= ySpeed;
                ySpeed -= 1; 

                if (x + 100 > xpig && x < xpig + 100 && y + 100 > ypig && y < ypig + 100) {
                    score+=100;
                    tfscore.setText(String.valueOf(score));
                    randomizePigPosition();
                    resetBirdPosition();
                }


                if (x < 0 || x > getWidth() || y > getHeight()) {
                    resetBirdPosition(); 
                }
                repaint();
            });
        }

        public void shoot(int xSpeed, int ySpeed) {
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
            time.start();
        }

        private void resetBirdPosition() {
            x = 0; 
            y = 350; 
            xSpeed = 0;
            ySpeed = 0;
            time.stop(); 
        }

        private void randomizePigPosition() {
            this.ypig = (int) (Math.random() * 350); 
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imgbg, 0, 0, 1000, 500, this);
            g.drawImage(imgab, x, y, 40, 40, this);
            g.drawImage(imgpig, xpig, ypig, 40, 40, this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new W9_8();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class Listener implements ActionListener {
        draw gamePanel;
        JTextField tfscore, tfbird, tfshoot, tfangle;

        public Listener(draw gamePanel, JTextField tfscore, JTextField tfbird, JTextField tfshoot, JTextField tfangle) {
            this.gamePanel = gamePanel;
            this.tfscore = tfscore;
            this.tfbird = tfbird;
            this.tfshoot = tfshoot;
            this.tfangle = tfangle;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("OK")) {
                int shootSpeed = Integer.parseInt(tfshoot.getText()); 
                int angle = Integer.parseInt(tfangle.getText());

                double radians = Math.toRadians(angle); 
                int xSpeed = (int) (shootSpeed * Math.cos(radians)); 
                int ySpeed = (int) (shootSpeed * Math.sin(radians));


                gamePanel.shoot(xSpeed, ySpeed);
            }
        }
    }
}
