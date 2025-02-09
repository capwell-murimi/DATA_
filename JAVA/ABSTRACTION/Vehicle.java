package ABSTRACTION;

public abstract class Vehicle {
    String name = "";
    
    Vehicle(String name){
        this.name = name;
    }
    abstract void name(); 
}
