/**
 * Compiltation: javac Bicycle.java
 * Execution: java Bicycle
 * 
 */


 public class Bicycle {
     public static void main(String[] args) {
         Bicycle bikeA = new Bicycle(); // Make a new bike 
         Bicycle bikeB = new Bicycle(); // Make another bike

         // Invoke the changeCadence method
         bikeA.changeCadence(20);
         bikeB.changeCadence(50);

         bikeA.printStates(); // Output- Cadence: 20, Speed: 0, Gear: 1
         bikeB.printStates(); // Output- Cadence: 50, Speed: 0, Gear: 1

         bikeA.speedUp(10); 
         bikeA.changeGear(2); 

         bikeB.speedUp(20); 
         bikeB.changeGear(3); // 1 -> 3 ...alrighty then

         bikeA.printStates(); // Output- Cadence: 20, Speed: 10, Gear: 2
         bikeB.printStates(); // Output- Cadence: 50, Speed: 20, Gear: 3

    
         

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

     void speedUp(int increment) {
         speed = speed + increment;
     }

     void applyBakes(int decrement) {
         speed = speed - decrement; 
     }

     void printStates() {
         System.out.println("Cadence: " + cadence + ", Speed: " + speed + ", Gear: " + gear);
     }
 }