/**
 * Compilation: javac InstanceOf.java
 * Executin: java InstanceOf
 */

 public class InstanceOf {
     
     public static void main(String[] args) {
         Parent obj1 = new Parent();
         Parent obj2 = new ChildClass(); // ??? Intriguing

         System.out.println("obj1 instanceof Parent: " + (obj1 instanceof Parent)); 
         System.out.println("obj1 instanceof ChildClass: " + (obj1 instanceof ChildClass));
         System.out.println("obj1 instanceof DemoInterface: " + (obj1 instanceof DemoInterface));
         System.out.println("obj2 instanceof Parent: "+ (obj2 instanceof Parent));
         System.out.println("obj2 instanceof ChildClass: "+(obj2 instanceof ChildClass));
         System.out.println("obj2 instanceof DemoInterface: "+(obj2 instanceof DemoInterface));

         
     }
 }
    class Parent {}; // Empty parent class just for to have a child
    class ChildClass extends Parent implements DemoInterface {};
    interface DemoInterface {}; // How fancy, not even "MyInterface"