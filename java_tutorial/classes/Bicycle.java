/**
 * Compilation: javac Bicycle.java
 * Execution: java Bicycle 
 */

 public class Bicycle {
    // protected cadence, gear, and speed because
    // if I have something inherit from these, the descendants should still
    // have cadence, gear, and speed;
    protected int cadence; 
    protected int gear; 
    protected int speed; 

    // Provide values for the initial state
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int newCadence) {
        cadence = newCadence;
    }
    
    public int getGear() {
        return gear;
    }
    
    public void setGear(int newGear) {
        gear = newGear;
    }

    public int getSpeed() {
        return speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement; // speed = speed - decrement;
    }

    public void speedUp(int increment) {
        speed += increment; // speed = speed + increment;
    }

    public void printState() {
        System.out.println("Gear: "+ getGear()+"\nSpeed: "+getSpeed()+"\nCadence: "+getCadence());
    }

    public static void main(String[] args) {
        System.out.println("Bicycle.java rides again!");
        Bicycle testBike = new Bicycle(60, 20, 1);
        testBike.printState();
        
    }
 }

 



