/**
 * Compilation: javac FarenheitConverter.java
 * Execution: java FarenheitConverter
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FarenheitConverter implements ActionListener {

    public void AssembleGUIComponents() {
        JButton convertTheTemperature = new JButton("Convert to Celsius");
        convertTheTemperature.setMnemonic(KeyEvent.VK_C);
        convertTheTemperature.setAlignmentX(Component.CENTER_ALIGNMENT);
        convertTheTemperature.addActionListener(this);
    }

    public void convertButtonClicked(ActionEvent e) {
        System.out.println(e);
    }
    
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Farenheit to Celsius Converter"); // frame = what I feel like typing again and again
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default operation for the program

        frame.add(AssembleGUIComponents);


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