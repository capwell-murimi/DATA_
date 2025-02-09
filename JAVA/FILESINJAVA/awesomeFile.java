package FILESINJAVA;
import java.io.File;

public class awesomeFile {
    public static void main(String[] args) {
        File file = new File("exampleFile.txt");

        try {
            if(file.createNewFile()){
                System.out.println("File created: "+file.getName());
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch (Exception e) 
        {
            System.out.println("An error occured");    
        }
    }
}
