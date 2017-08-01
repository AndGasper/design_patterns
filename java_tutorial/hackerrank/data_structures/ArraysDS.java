/**
 * Compilation: javac ArrayDS.java
 * Execution: java ArrayDS
 * 
 * Problem statement: Print N intergers in A in reverse order as a single line of space-separated integers
 */

import java.io.*;
import java.util.*;

public class ArraysDS {

    static int[] reverseArray(int[] array) { 
        int lengthOfArray = array.length; // grab the length of the array
        int[] reversedArray = new int[lengthOfArray]; // Make a new array for the reversed integers 
        int i = 0; // For start of array 
        int j = lengthOfArray-1; // To start at end of array 
        while (i < lengthOfArray) {
            reversedArray[i] = array[j]; 
            System.out.println(array[j]);
            j--; 
            i++;
        }
        return reversedArray; 
    }
    public static void main(String[] args) {
        // We'll start simple...Let's just reverse a hardcoded array
        // [1, 2, 3, 4] -> [4, 3, 2, 1]
        int[] testArray = {1, 2, 3, 4}; 
        System.out.println(reverseArray(testArray));         
    }
}