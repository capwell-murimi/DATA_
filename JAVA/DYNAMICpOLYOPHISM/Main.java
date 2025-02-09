package DYNAMICpOLYOPHISM;

import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Animal animal;

        Scanner scanner = new Scanner(System.in);
        String new_animal = scanner.next();

        if(new_animal.equals("cat")){
            animal = new Cat();
            animal.sound();
        }
        else if(new_animal.equals("dog")){
            animal = new Dog();
            animal.sound();
        }

        else {
            animal = new Animal();
            animal.sound();
        }

        scanner.close();
    }
}
