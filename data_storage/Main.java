import java.util.*;



/*
* Compilation: javac Main.java
* Execution: java Main
*/

public class Main {
    public static void main(String[] args) {

        class Bicycle {
            int cadence = 0;
            int speed = 0; 
            int gear = 1; // start in first gear

            void changeCadence(int newValue) {
                cadence = newValue;
            }

            void changeGear(int newValue) {
                gear = newValue;
            }

            void speedUp(int increment) {
                speed = speed + increment;
            }

            void applyBrakes(int decrement) {
                speed = speed - decrement;
            }
            
            void printStates() {
                System.out.println("cadence: " + cadence);
                System.out.println("speed: " + speed);
                System.out.println("gear: " + gear);
            }
        }

        Bicycle bike = new Bicycle(); 
        bike.printStates();
    }
    
};



