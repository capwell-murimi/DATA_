package ABSTRACTION;


public class Car extends Vehicle{

   Car(String name){
        super(name);
   }

   void name(){
    System.out.println(this.name);
   }
}
