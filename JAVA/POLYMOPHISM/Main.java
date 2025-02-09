package POLYMOPHISM;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        
        Animal animal2 = new Cat();

        animal2.sound();
        animal.sound();
        dog.sound();
        cat.sound();
    }

    


}
