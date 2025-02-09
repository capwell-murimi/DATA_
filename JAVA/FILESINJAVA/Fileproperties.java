package FILESINJAVA;
import java.io.File;

public class Fileproperties {
    public static void main(String[] args) {
        try {
            File file = new File("exampleFile.txt");

            System.out.println(file.getName());
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.length());
            System.out.println(file.canRead());
            System.out.println(file.canWrite());

        } catch (Exception e) {
            System.out.println("Warning, ERROR!!");
        }
    }
}
