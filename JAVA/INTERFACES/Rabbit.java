package INTERFACES;

public class Rabbit implements Prey{
    @Override
    public void getsEaten(){
        System.out.println("Rabbit gets eaten by the hawk");
    }

    public void small(){
        System.out.println("The rabbit is so small");
    }
    public void swim(){
        System.out.println("A rabbit cannot swim lol");
    }
}
