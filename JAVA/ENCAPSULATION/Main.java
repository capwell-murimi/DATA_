package ENCAPSULATION;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", "X5", 5000000, 4);
        Car car1 = new Car("Audi", "Q7", 7000000, 4);
        //Bicycle bicycle = new Bicycle("Mountain", "Samsung", 100000, 2);

        car1.copy(car);

        
        System.out.println(car.getName());
        System.out.println(car.getModel());
        System.out.println(car.getPrice());
        System.out.println(car.getDoors());
        System.out.println();

        System.out.println(car1.getName());
        System.out.println(car1.getModel());
        System.out.println(car1.getPrice());
        System.out.println(car1.getDoors());
        System.out.println();





       /*  System.out.println("Baiskeli section");
        bicycle.setName("Electric");
        System.out.println(bicycle.getName());
        System.out.println(bicycle.getModel());
        System.out.println(bicycle.getPrice());
        System.out.println(bicycle.getPedals());*/

        

    }
}
