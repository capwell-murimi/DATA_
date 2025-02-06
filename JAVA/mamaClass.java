public class mamaClass {
    
    public static void main(String[] args) {
        Car myCar = new Car();

        Car myWifeCar = new Car();

        myWifeCar.make = "Toyota";

       System.out.println(myCar.make);
       System.out.println(myWifeCar.make);
    }
}
