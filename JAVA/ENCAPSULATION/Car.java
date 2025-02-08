package ENCAPSULATION;

public class Car extends Vehicle{

    //private String name;
    //private String model;
    //private int price;
    private int doors;

    
    Car(String name,String model,int price,int doors){
        super(name,model,price);
        this.doors = doors;
    }

    public int getDoors(){
        return doors;
    }

    int setDoors(int doors){
        this.doors = doors;
        return this.doors;
    }


    void copy(Car x){
        this.setName(x.getName());
        this.setModel(x.getModel());
        this.setPrice(x.getPrice());
        this.setDoors(x.getDoors());
    }
}
