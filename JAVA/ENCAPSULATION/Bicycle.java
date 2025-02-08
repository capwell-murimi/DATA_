package ENCAPSULATION;

public class Bicycle extends Vehicle{
  private int pedals; 

  Bicycle(String name, String make, int price, int pedals){
    super(name,make,price);
    this.pedals = pedals;
  } 

  int getPedals(){
    return pedals;
  }
}
