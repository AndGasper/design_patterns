/**
 * Compilation: javac Arthimetic.java
 * Execution: java Arthimetic
 */



 public class Arthimetic {
     public static void main(String[] args) {
         int result = 1 + 4; // Addition       
         int original_result = result;

         result = result - 1; // 4; Subtraction
         System.out.println("Result: "+original_result+"\nResult after result-1: "+result);

         result *= 2; // 8; Multiplication
         System.out.println("result*=2: "+result); // Integer arthimetic

         result /= 2; // 4; Division; Confusing syntax
         System.out.println("result /=2; "+result);

         result = result%3; // Modulo 
         System.out.println("result = result%3; "+result);

     }
 }