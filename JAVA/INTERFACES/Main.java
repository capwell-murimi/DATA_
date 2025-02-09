package INTERFACES;

public class Main {
    public static void main(String[] args) {
        Hawk hawk = new Hawk();
        Fish fish = new Fish();
        Rabbit rabbit = new Rabbit();

        hawk.eatUp();
        rabbit.small();
        fish.getsEaten();
    }
}
