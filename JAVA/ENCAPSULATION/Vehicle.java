package ENCAPSULATION;

public class Vehicle {
    private String name = "";
    private String model = "";
    private int price = 0;

    Vehicle(String name, String model, int price){
       this.setName(name);
       this.setModel(model);
       this.setPrice(price);
    };

   public String getName(){
        return name;
    }

    public String getModel(){
        return model;
    }
    public int getPrice(){
        return price;
    }


    public String setName(String name){
        this.name = name;
        return this.name;
    }
    public String setModel(String model){
        this.model = model;
        return this.model;
    }


    public int setPrice(int price){
        this.price = price;
        return this.price;
    }

}
