/**
 * Compilation: javac FarenheitConverter.java
 * Execution: java FarenheitConverter
 */



import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FarenheitConverter extends JPanel implements ActionListener {
    
    protected JButton convertButton;
    
    public FarenheitConverter() {
        convertButton = new JButton("Convert", null); 
        convertButton.addActionListener(this); 

        add(convertButton); // Add the convert button to the frame
    }
    

    public String actionPerfomed(ActionEvent e) {
        System.out.println(e);
        return "Clicked!";
    }
    
    
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Farenheit to Celsius Converter"); // frame = what I feel like typing again and again
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default operation for the program

        FarenheitConverter newConverter = new FarenheitConverter();


        // frame.pack(); // Size the frame
        frame.setSize(300, 600); // x: 300 px, y: 600 px 
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}