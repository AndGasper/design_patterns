import javax.swing.*;

public class HelloWorldSwing {
    /**
     * Create the GUI and show it. 
     * There's a comment here about thread safety...
     * "For thread safety, this method should be invoked from the event-dispatching thread"
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        // JFrame is apparently a type
        JFrame frame = new JFrame("HelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Add label
        JLabel helloWorld = new JLabel("Hello world");
        JLabel kittenMittens = new JLabel("Kitten mittens"); 
        frame.getContentPane().add(helloWorld);
        frame.getContentPane().add(kittenMittens); 
        
        // Display the window
        frame.pack(); 
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        // creating and showing this application's GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}