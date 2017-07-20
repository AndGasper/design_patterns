/**
 * Compilitation: javac BicycleInterface.java
 * Execution: java BicucleInterface 
 */

 /**
  *  What is an Interface? 
  * "In its most common form, an interface is a group of related methods 
  *  with empty bodies"
 */
   

 interface Bicycle {
     // cadence = wheel revolutions per minute (rpm)
     void changeCadence(int newValue);
     
     void changeGear(int newValue);

     void speedUp(int increment);

     void applyBrakes(int decrement);

 }

// Had to change the class name to match the file
class BicycleInterface implements Bicycle {
     int cadence = 0;
     int speed = 0;
     int gear = 1; 

     // implementation of an interface requires all methods be implemented/defined?

     // Had to make the methods public 
     public void changeCadence(int newValue) {
         cadence = newValue;
     }

     public void changeGear(int newValue) {
         gear = newValue;
     }

     public void speedUp(int increment) {
         speed = speed + increment;
     }

     public void applyBrakes(int decrement) {
         speed = speed - decrement;
     }

     void printStates() {
         System.out.println("Cadence: "+cadence+"\nSpeed: "+speed+"\nGear: "+gear);
     }

     public static void main(String[] args) {
     System.out.println("Did this compile and run?");
     BicycleInterface testBike = new BicycleInterface();
     testBike.printStates();
 }
 }

 