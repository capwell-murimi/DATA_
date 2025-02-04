import java.util.Scanner;

public class Loops {
    public static void main(String[] args){
        //while loop
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while(name.isBlank()){
            System.out.print("Name: ");
            name = scanner.nextLine();
        }
        System.out.println("Hello "+name);
        //scanner.close();


        //for loop
        for(int i = 0; i<=10;i++){
            System.out.println(i);
        }
        System.out.println("Number 1-10 Done!");


        for(int i =10;i>=0;i--){
            System.out.println(i);
        }
        System.out.println("Happy new Year!");


        //Nested for loop
        int rows,columns;
        String symbol = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        rows = input.nextInt();
    

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter number of columns: ");
        columns = input2.nextInt();

        Scanner input3 = new Scanner(System.in);
        System.out.println("Enter Symbol: ");
        symbol = input3.next();

        for(int i = 1;i <= rows;i++){
           System.out.println();
            for(int j = 1;j<=columns;j++){
                System.out.print(symbol);
            }
        }
        /*input.close();
        input2.close();
        input3.close();*/
    }
}
