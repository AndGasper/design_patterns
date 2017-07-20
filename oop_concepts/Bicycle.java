/**
 * Compiltation: javac Bicycle.java
 * Execution: java Bicycle
 * 
 */

import java.lang.Math; // For absolute value
 public class Bicycle {
     public static void main(String[] args) {
         Bicycle bikeA = new Bicycle(); // Make a new bike 
         Bicycle bikeB = new Bicycle(); // Make another bike
         TandemBike tandemBike1 = new TandemBike();

         System.out.println("Number of seats on a tandem bike: " + tandemBike1.numberOfSeats);
         System.out.println("Tandem bike instance initial state"); 
         tandemBike1.printStates();
        //  tandemBike1.speedUp(3);
        //  tandemBike1.printStates();
        // tandemBike1.applyBrakes(7); // Test to see if speed stops at 0 
        // tandemBike1.printStates();

         tandemBike1.speedUp(20); 
         tandemBike1.speedUp(-9);
         System.out.println("tandemBike1.speedUp(20) then tandemBike1.speedUp(-9);\nspeed should be 11");
         tandemBike1.printStates();

         tandemBike1.speedUp(0); // What happens if I try and speed up by 0?
         System.out.println("tandemBike1.speedUp(0) then print the states"); 
         tandemBike1.printStates(); // Whoops. That set the speed to 0...


         // Invoke the changeCadence method
         bikeA.changeCadence(20);
         bikeB.changeCadence(50);

         // bikeA.printStates(); // Output- Cadence: 20, Speed: 0, Gear: 1
         // bikeB.printStates(); // Output- Cadence: 50, Speed: 0, Gear: 1

         bikeA.speedUp(10); 
         bikeA.changeGear(2); 

         bikeB.speedUp(20); 
         bikeB.changeGear(3); // 1 -> 3 ...alrighty then

        //  bikeA.printStates(); // Output- Cadence: 20, Speed: 10, Gear: 2
        //  bikeB.printStates(); // Output- Cadence: 50, Speed: 20, Gear: 3

     }

     int cadence = 0; 
     int speed = 0;
     int gear = 1;

     void changeCadence(int newValue) {
         cadence = newValue; // Set the cadence equal to the integer that was passed in
     }

     void changeGear(int newValue) {
         gear = newValue; // Set the gear equal to the new value that was passed in
     }

     int speedUp(int increment) {
        // Because users always seem to find a way 
        // if the increment is less than 0, apply the brakes, else, speed up

        // if (increment < 0) {
        //      applyBrakes(Math.abs(increment)); // absolute value = sqrt(x * x); 
        //  } else {
        //      speed = speed + increment; 
        //  }
        
        
        // Here it is with a ternary because aren't I so fancy? 
        return speed = (increment < 0) ? (applyBrakes(Math.abs(increment))) : (speed+increment); 

        // +increment was just setting speed to 0, so I added back the speed+increment 

        // I was going to try a switch statement, but I cannot logically justify that for speed up. 


     }

     int applyBrakes(int decrement) {

        // In case they try and slow down more than they were actually going 
        if ( (speed - decrement) < 0 ) {
            return speed = 0;
        } else {
            return speed -= decrement;
        }





        
     }

     void printStates() {
         System.out.println("Cadence: " + cadence + ", Speed: " + speed + ", Gear: " + gear);
     }
 }


 class TandemBike extends Bicycle {
     int numberOfSeats = 2;

     // inherits all the methods available to bike
 }