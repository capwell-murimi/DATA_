package INHERITANCE_IN_JAVA;

public class Hero extends Person{
    String power;
    Hero(String name, int age, String power){
        super(name, age);
        this.power = power;
    }

    public String toString(){
        return  (this.name + '\n' + this.age + '\n' + this.power);
    }
}
