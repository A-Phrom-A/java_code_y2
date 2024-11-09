/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author SSP
 */
public class BounceBallApp extends JFrame {
    public BounceBallApp() {
        add(new BallControl());
    }
    public static void main(String[] args) {
        
        JFrame frame = new BounceBallApp();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BounceBallApp");
        frame.setSize(400, 320);
        frame.setVisible(true);
    } 
}