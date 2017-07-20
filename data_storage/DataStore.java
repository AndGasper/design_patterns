/**
 * Compiltation: javac DataStore.java
 * Execution: java DataStore
 */

 import java.util.*; 
 


 public class DataStore {
     public static void main(String[] args) {
         System.out.println("Are we live?"); 
         DataStore testStore = new DataStore(); 
         HashMap<String, String> successorList = new HashMap<String, String>(); 
         successorList.put("Kitten", "Mittens");
         successorList.put("Wam", "Sham");
         successorList.put("Blam", "Kachow");
         successorList.put("Kachigga", "My trigga");
         System.out.println(testStore.outputHashKeys(successorList));
     }
        public Set outputHashKeys(HashMap<String, String> succesorList) {
            HashMap<String,String> successorList = succesorList;  
            int i = 0; 
            int numberOfSuccessors = successorList.size(); // .size() method returns an integer
            while (i < numberOfSuccessors) {
                System.out.println("i: "+i);
                i++; 
            }
            return succesorList.keySet();
        }

 }

 
