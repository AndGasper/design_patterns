import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends Frame implements WindowListener,ActionListener {
        TextField text = new TextField(20);
        Button b;
        private int numClicks = 0;

        public static void main(String[] args) {
                ButtonDemo myWindow = new ButtonDemo("My first window");
                myWindow.setSize(350,100);
                myWindow.setVisible(true);
        }

        public ButtonDemo(String title) {

                super(title);
                setLayout(new FlowLayout());
                addWindowListener(this);
                b = new Button("Click me");
                b.addActionListener(this);
                add(b);
                add(text);
                
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println(e);
                numClicks++;
                text.setText("Button Clicked " + numClicks + " times");
        }

        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}