package INHERITANCE_IN_JAVA;

public class Main {
    
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();

        car.move();
        bicycle.stop();

        Hero hero1 = new Hero("Batman",42,"Money");
        Hero hero2 = new Hero("Superman",43,"Kila kitu");

        System.out.println(hero1.toString());
        System.out.println(hero2.toString());
    }
}
