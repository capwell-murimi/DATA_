import java.util.Scanner;

public class Exceptionhandling {
    public static void main(String[] args) {
        int number = 0;

        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Enter a number");
                number = scanner.nextInt();
                System.out.println(number+" is your number");
                break;
            }
            catch (Exception e)
            {
                System.out.println("please enter a number");
                scanner.next();
            }
        }

        scanner.close();
    }
}

