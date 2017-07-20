/**
 * Compiltation: javac ArrayDemo.java
 * Execution: java ArrayDemo
 */

public class ArrayDemo {
    public static void main(String[] args) {
        System.out.println("Working through java demo");

        int[] arrayOfIntegers; // Declare an array of integers

        arrayOfIntegers = new int[10]; 
        // Too lazy to write this a bunch of times so while loop it is
        int i = 0;
        while (i < 10) {
            arrayOfIntegers[i] = 100 * i; 
            System.out.println("Element at index " + i + ": " + arrayOfIntegers[i]);
            i++;
        }
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };
        System.out.println(names[0][0] + names[1][0]); // Output: Mr. Smith
        
        char[] copyFrom = {'K', 'i', 't', 't', 'e', 'n'};
        char[] copyTo = new char[6]; 
        System.arraycopy(copyFrom, 0, copyTo, 0, 6);
        System.out.println(new String(copyTo)+" Mittens");

    }
}