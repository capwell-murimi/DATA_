package COPYOBJECTS;

public class Fruits {
    String name;
    Fruits(String name){
        this.name = name;
    }

    void copy (String[] fruit){
        String[] copiedFruits = new String[fruit.length];
        for(int i = 0; i < fruit.length; i++){
            copiedFruits[i] = fruit[i];
        }
        // Print copied fruits for verification
        for(String f : copiedFruits){
            System.out.println(f);
        }
    }
}
