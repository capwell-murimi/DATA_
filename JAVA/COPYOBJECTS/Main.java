package COPYOBJECTS;

public class Main {
    public static void main(String[] args) {
        Fruits[] fruit = new Fruits[3];

        Fruits fruit1 = new Fruits("Mangoe");
        Fruits fruit2 = new Fruits("Banana");
        Fruits fruit3 = new Fruits("Passion");

        fruit[0] = fruit1;
        fruit[1] = fruit2;
        fruit[2] = fruit3;


        Fruits[] fruit0 = new Fruits[3];

        Fruits fruit4 = new Fruits("Apple");
        Fruits fruit5 = new Fruits("Orange");
        Fruits fruit6 = new Fruits("Watermelon");

        fruit0[0] = fruit4;
        fruit0[1] = fruit5;
        fruit0[2] = fruit6;


        for(Fruits i: fruit){
            System.out.println(i.name);
        }
        
        System.out.println();
        for(int i =0; i < fruit0.length; i++){
            System.out.println(fruit0[i].name);
        }

        
    }

}
