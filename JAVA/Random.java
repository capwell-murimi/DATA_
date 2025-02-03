
public class Random {
    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();

        int x = random.nextInt(6)+1;

        double y = random.nextDouble();

        boolean z = random.nextBoolean();

        System.out.println("Random number: "+x);
        System.out.println(y);
        System.out.println(z);
    }
}
