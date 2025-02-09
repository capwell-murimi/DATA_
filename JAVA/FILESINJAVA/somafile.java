package FILESINJAVA;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;

public class somafile {
    public static void main(String[] args) {
       try {
        File file = new File("exampleFile.txt");

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String maneno = reader.nextLine();
            System.out.println(maneno);
        }
        reader.close();
       } catch (Exception e) {
        System.out.println("Ooh no!!!! there has been an error");
       }
    }
    
}
