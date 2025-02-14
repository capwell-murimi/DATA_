package LAMBDA_EXPRESSIONS;

public class Main {
    public static void main(String[] args) {
        Example example = (play,drive) -> {System.out.println("someone is "+drive+ " and someone is "+play); return("Price: 50000");};
        System.out.println(example.actionPerformed("playing","driving"));
    }
}
