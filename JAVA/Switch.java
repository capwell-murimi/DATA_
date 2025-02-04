import java.util.Scanner;
public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a day: ");

        String day = input.nextLine();

        switch (day) {
            case "Monday": System.out.println("Leo ni Monday");
            break;
            case "Tuesday": System.out.println("Leo ni Tuesday");
            break;
            case "Wednesday": System.out.println("Leo ni wednesday");
            break;
            case "Thursday": System.out.println("Leo ni Thursday");
            break;
            case "Friday": System.out.println("Leo ni Friday");
            break;
            case "Saturday": System.out.println("Leo ni Sato");
            break;
            case "Sunday": System.out.println("Leo ni Sunday");
            break;
        
            default: System.out.println(""+day+" is not a day of the week!");
                break;
        }
        input.close();
    }
    }
