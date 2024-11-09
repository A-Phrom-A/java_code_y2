import javax.swing.JOptionPane;

public class W1_1 {
    public static void main(String[] args) throws Exception {
        // รับข้อมูลอุณหภูมิจากผู้ใช้ผ่านหน้าต่างโต้ตอบ
        String fahrenheitString = JOptionPane.showInputDialog(null, "Enter temperature in Fahrenheit:", "Fahrenheit Input", JOptionPane.QUESTION_MESSAGE);
        
        // แปลงค่าอุณหภูมิจาก String เป็น double
        double fahrenheit = Double.parseDouble(fahrenheitString);
        
        // แปลงอุณหภูมิจากฟาเรนไฮต์เป็นเซลเซียส
        double celsius = (fahrenheit - 32) * 5 / 9;
        
        // ปรับค่าผลลัพธ์ให้มีทศนิยมสองตำแหน่ง
        celsius = (int)(celsius * 100) / 100.0;
        
        // แสดงผลลัพธ์ในหน้าต่างโต้ตอบ
        JOptionPane.showMessageDialog(null, "The temperature in Celsius is " + celsius, "Celsius Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
