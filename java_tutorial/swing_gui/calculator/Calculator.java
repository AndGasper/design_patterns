import java.awt.*;
import java.awt.event.*; 


public class Calculator extends Frame implements WindowListener, ActionListener {
    TextField text = new TextField(20); 
    // There's probably a lazier way to declare the buttons...
    // Ah, these are of type Button which is apparently a type
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero; 
    Button decimalPoint; 
    private String numberClicked = ""; // empty string by default
    
    public static void main(String[] args) {
        Calculator calculatorWindow = new Calculator("Calculator"); 
        calculatorWindow.setSize(250, 750); // x by y; calculators are typically longer than they are tall
        calculatorWindow.setVisible(true);  // setVisible = true so you can actually see it
    }

    public Calculator(String title) {
        super(title);
        setLayout(new FlowLayout()); 
        addWindowListener(this);
         
        add(text); // From up top
        digitButtons(); // Creates and appends all the calculators buttons into the window
    }
    public void digitButtons() {
        // I could maybe do something fancy with an array and appending these, but for now, let's just hardcode  
        // three in and I am already feeling so lazy that I think I should be boujee

        // Make the buttons
        zero = new Button("0"); 
        one  = new Button("1"); 
        two = new Button("2"); 
        three = new Button("3");
        four = new Button("4");
        five = new Button("5");  
        six = new Button("6");
        seven = new Button("7");
        eight = new Button("8");
        nine = new Button("9");
        decimalPoint = new Button("."); 

        // Attach action listeners to the buttons
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        decimalPoint.addActionListener(this);
        
        // Append the buttons to the window
        add(zero);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
        add(decimalPoint);  
    }

    public void actionPerformed(ActionEvent e) {
        // System.out.println(e);
        System.out.println(e.getActionCommand()); 
        // if number clicked is equal to the empty string, set the value to whatever button was pressed.
        // else if the numberClicked does not equal the empty string then append on whatever was pressed

        // May need to pull this logic into a full fledged if/else loop or maybe even a switch statement once I add in the operators 
        numberClicked = (numberClicked == "") ?  e.getActionCommand() : (numberClicked+e.getActionCommand()); 
        
        text.setText(numberClicked); 
    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0); 
    } 

    // For now, these are just here to escape the Abstract issue
    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
}