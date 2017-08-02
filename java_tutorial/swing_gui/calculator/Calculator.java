import java.awt.*;
import java.awt.event.*; 


public class Calculator extends Frame implements WindowListener, ActionListener {
    TextField text = new TextField(20); 
    // There's probably a lazier way to declare the buttons...
    // Ah, these are of type Button which is apparently a type

    // Declare the digit buttons (0-9), decimal point (.) and the operator buttons (+, -, *, /);
    // Equals sign (=) as well 
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

    Button plusSign;
    Button minusSign;
    Button multiplicationSign;
    Button divisionSign; 
    Button equalsSign;

    // Declare the clear screen button, the clear history button, and the backspace button
    Button clear;
    Button clearEverything;
    Button backSpace;


    // Declare the Strings that will hold the numbers; Make them exclusive to the class (private);  
    // Empty string by default 
    // For now, let's stick with two values for operations
    // Potential for more by storing the input in a new HashMap<String, String>(); 
    // (numberOne) (operator) (numberTwo) (operator) 
    private String numberOne = "";
    private String numberTwo = ""; 

    // Declare the private String that will hold the operator; 
    // Empty string by default 

    private String operator = "";
    
    public static void main(String[] args) {
        Calculator calculatorWindow = new Calculator("Calculator II: Java Boogaloo"); 
        calculatorWindow.setSize(250, 550); // x by y; calculators are typically longer than they are tall
        calculatorWindow.setVisible(true);  // setVisible = true so you can actually see it
    }

    public Calculator(String title) {
        super(title);
        setLayout(new FlowLayout()); 
        addWindowListener(this);
         
        add(text); // Append text field that will show the calculation
        createDigitButtons(); // Method creates and appends all the calculators buttons into the window
        createOperatorButtons(); // Method creates and appends all operator buttons into the window 
        createEditingButtons(); // Method creates and appends backspace, clear, and clear everything buttons
    }

    // Creates and appends backspace, clear, and clear everything buttons
    public void createEditingButtons() {
        clear = new Button("C");
        clearEverything = new Button("CE");
        backSpace = new Button("I don't know how to make an arrow, so here's a <-");

        clear.addActionListener(this);
        clearEverything.addActionListener(this);
        backSpace.addActionListener(this);

        add(clear);
        add(clearEverything);
        add(backSpace);
    }
    public void createDigitButtons() {
        // I could maybe do something fancy with an array and appending these, but for now, let's just hardcode  
        // three in and I am already feeling so lazy that I think I should be boujee

        // Make the digit buttons: 0-9 and a decimal point
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

        // Attach action listeners to the buttons pass 'this' in for the scope 
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
        // System.out.println(this); // Calculator[frame0,0,0,0x0,invalid,hidden,layout=java.awt.FlowLayout,title=Calculator II: Java Boogaloo,resizable,normal]

    }
    public void createOperatorButtons() {
        // Make the addition (+), subtraction (-), multiplication (*) , and division (/) buttons
        plusSign = new Button("+");
        minusSign = new Button("-"); 
        multiplicationSign = new Button("*");
        divisionSign = new Button("/");
        equalsSign = new Button("=");

        // Attach action listeners to the operator buttons
        plusSign.addActionListener(this);
        minusSign.addActionListener(this);
        multiplicationSign.addActionListener(this);
        divisionSign.addActionListener(this);
        equalsSign.addActionListener(this);

        // Append the operator buttons to the window or maybe frame?
        add(plusSign);
        add(minusSign);
        add(multiplicationSign);
        add(divisionSign);
        add(equalsSign);
    }

    public void actionPerformed(ActionEvent e) {
        // System.out.println(e);
        System.out.println(e.getActionCommand()); 
        // if number clicked is equal to the empty string, set the value to whatever button was pressed.
        // else if the numberClicked does not equal the empty string then append on whatever was pressed

        // May need to pull this logic into a full fledged if/else loop or maybe even a switch statement once I add in the operators 
        String textToDisplay = numberOne+operator+numberTwo; // textToDsplay holds the concatenated String values of the user input
        String buttonPressed = e.getActionCommand(); 
        
        // in case of operator
        if (buttonPressed.equals("+") || buttonPressed.equals("-") || buttonPressed.equals("*") || buttonPressed.equals("/")) {
            operator = e.getActionCommand(); 
        } else if ( !(operator.equals(""))) {
            numberTwo += buttonPressed;  // If they've pressed an operator, assume the input is intended for the second number; 
        } else {
            numberOne += buttonPressed; // Assume the input was intended for the 
        }

        if (buttonPressed.equals("=") && !(numberOne.equals("")) && !(numberOne.equals(""))) {
            numberTwo = numberTwo.substring(0, numberTwo.length()-1); // Shoddy logic on my part, so I trim off the equal sign before pasisng number two onto doMath()

            // If either of the digits contains a . -> that floating point arthimetic needs to be performed 

            textToDisplay = (numberOne.contains(".") || numberTwo.contains(".")) ? (textToDisplay + " = " + doFloatingPointMath(numberOne, numberTwo, operator)) : (doIntMath(numberOne, numberTwo, operator)); 

            // textToDisplay = textToDisplay + "= " + doIntMath(numberOne, numberTwo, operator); // Pass to the doMath function. 
            
        }
        textToDisplay = (buttonPressed.equals("C")) ? clearScreen(textToDisplay) : (textToDisplay); // If they hit clear, clear the screen using the clearScreen method, else leave textToDisplay = textToDisplay

        // numberClicked = (numberClicked == "") ?  e.getActionCommand() : (numberClicked+e.getActionCommand()); 
        
        text.setText(textToDisplay); 
    }

    public String doIntMath(String num1, String num2, String operator) {
        // Should consider having logic for floating point addition... 
        // I'm sick of typing Integer.parseInt( ) again and again, so let's just do it here
        int numberOne = Integer.parseInt(num1); 
        int numberTwo = Integer.parseInt(num2);
        String result = "";
        switch(operator) {
            case("+"): 
                result = Integer.toString(numberOne + numberTwo);
                break;
            case("-"):
                result = Integer.toString(Integer.parseInt(num1) - Integer.parseInt(num2)); 
                break;
            case("*"): 
                result = Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2)); 
                break;
                
            case("/"):
                if (numberTwo > numberOne) {
                    System.out.println("numberTwo > numberOne"); 
                    result = doFloatingPointMath(num1, num2, "/"); // For a/b, if b > a, then decimal result, so pass the original strings along to the floating point math function. 
                    break;
                } else if (Integer.toString(numberOne/numberTwo) == "0") {
                    result = doFloatingPointMath(num1, num2, "/");
                    break;
                } else {
                    result = Integer.toString(numberOne/numberTwo); 
                    break;
                }
            default:
                result = "Kitten mittens";
        }
        return result; 
    }

    public String doFloatingPointMath(String num1, String num2, String operator) {
        String result = ""; 
        System.out.println("doFloatingPointMath function"); 
        Float numberOne = Float.parseFloat(num1); 
        Float numberTwo = Float.parseFloat(num2); 

        switch(operator) {
            case("+"):
                result = Float.toString(numberOne + numberTwo);
                break;

            case("-"):
                result = Float.toString(numberOne - numberTwo);
                break;

            case("*"):
                result = Float.toString(numberOne * numberTwo);
                break;

            case("/"):
                result = Float.toString(numberOne/numberTwo);
                break; 

            default: 
                result = "Floating point kittens";
        }
        
        return result;

    }

    public void reset() {

    }

    // Method for clearing the screen. Sets numberOne, numberTwo, and operator to back to "".
    public String clearScreen(String screenText) {
        screenText = ""; 
        numberOne = "";
        numberTwo = ""; 
        operator = ""; 
        return screenText;
    }
    

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0); 
    } 

    // For now, these are just here to escape the Abstract issue
    public void windowOpened(WindowEvent e) {
        System.out.println("Window was opened");
        // Occurred when window was opened
    }
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated triggered");
        // Occurred when window gained focus
    }
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified triggered");
        // Occurred when window was minimized
    }
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified triggered"); 
        // Occurred when window was opened following being minimized
    }
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated triggered");
        // Occurred following loss of focus
    }
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed triggered");
        // Have not seen this one triggered yet
    }
}