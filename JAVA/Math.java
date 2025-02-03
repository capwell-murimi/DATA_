import java.util.Scanner;
public class Math {
    public static void main(String[] args) {
        double x;
        double y;
        double z;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of x: ");

        x = input.nextDouble();

        System.out.println("Enter the value of y:");
        y = input.nextDouble();

        z = java.lang.Math.sqrt(x*x + y*y);

        System.out.println("The hypotenuse is: "+z);

        //close scanner
        input.close();
    }
}
