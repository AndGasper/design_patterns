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

        class MountainBike extends Bicycle {
            // hmm what defines a mountain bike
            
        }

        Bicycle bike1 = new Bicycle(); 
        Bicycle bike2bikeBoogaloo = new Bicycle();
        bike1.printStates();
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        bike2bikeBoogaloo.changeCadence(50);
        bike2bikeBoogaloo.speedUp(10);
        bike2bikeBoogaloo.changeCadence(40);
        bike2bikeBoogaloo.speedUp(10);
        bike2bikeBoogaloo.changeGear(4); // Gotta go fast
        bike2bikeBoogaloo.printStates();

    }
};



