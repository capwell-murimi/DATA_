package FILESINJAVA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Writeintofile {
    public static void main(String[] args)
    {
    try {
        FileWriter file = new FileWriter("exampleFile.txt");

        file.write("Hello there\n");
        file.write("My name is Capwell and I am trying to lean java");
        file.close();
        System.out.println("We have written into the file");
    }
    catch (IOException e)
    {
        System.out.println("Error occured");
    }
    catch (Exception e){
        System.out.println("Error occurred");
        e.printStackTrace();
    }
}
}

