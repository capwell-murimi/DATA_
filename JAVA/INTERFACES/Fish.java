package INTERFACES;

public class Fish implements Prey,Predator{
    @Override
    public void swim(){
        System.out.println("The fish is swimming away from the hawk");
    }
    public void small(){
        System.out.println("Small fish get eaten by big fish");
    }   

    public void big(){
            System.out.println("Big fish chase small fish");
        }
    public void eatUp(){
            System.out.println("Big fish eats up small fish");
        }
    public void getsEaten(){
            System.out.println("HUh! I already said small fish get eaten by big fish");
        }
}
