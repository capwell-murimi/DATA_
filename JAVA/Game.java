import java.util.Random;

public class Game{

    Random random;
    int x;

    Game(){
        random = new Random();
        roll();
    }

    void roll(){
        x = random.nextInt(6)+1;
        System.out.println(x);
    }
}
