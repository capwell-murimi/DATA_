package AUDIO;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Wimbo {
    public static void main(String[] args) {
        /*try {
            File file = new File("C:\\Users\\CapwellTheNerd\\Desktop\\DATA_\\JAVA\\AUDIO\\awesomemusic.wav");

            AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);

            String response = "";
            Scanner scanner = new Scanner(System.in);

            while(!response.equals("Q")){
                System.out.print("Enter P for play, S to stop and Q to quit: ");
                response = scanner.next();
                response = response.toUpperCase();

                switch (response) {
                    case "P": clip.start();
                    break;
                    case "S": clip.stop();
                    break;
                    case "Q": clip.close();
                    System.out.println("Exiting program");
                    scanner.close();
                    break;
                    default:
                    System.out.println("Type well DUM! DUM!");
                    break;
                }

            }
        } 
        catch (Exception e)
        {
            System.out.print("eRROR: "+e.getMessage());
        } */
       
        try {
            File file = new File("C:\\Users\\CapwellTheNerd\\Desktop\\DATA_\\JAVA\\AUDIO\\awesomemusic.wav");

            AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);

            String response = "";

            while(!response.equals("Q")){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter P for play, S to stop and Q to quit");
                response = scanner.next();
                response = response.toUpperCase();

                if(response.equals("P")){
                    clip.start();
                }
                else if(response.equals("S")){
                    clip.stop();
                }
                else if(response.equals("Q")){
                    clip.setMicrosecondPosition(0);
                }
                else{
                    System.out.println("Use appropriate key");
                    scanner.close();
                }
                System.out.println("Wimbo umeisha");

            }
        } catch (Exception e) {
            System.out.print("There has been an error: "+e.getMessage());
        }
        
            
        
    }
}
