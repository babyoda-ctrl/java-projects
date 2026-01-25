import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;


//AudioPlayer in java 😁
public class AudioPlayer{
    public static void main(String[] args) throws IOException {
        String filePath ="C:\\Users\\TOSHIBA\\Downloads\\24kGoldn - Company (Official Video) ft. Future.wav";
        File file = new File(filePath);


        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){


            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            String response = "";

            while(!response.equals("Q")){
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.println("Enter your choice: ");

                response = scanner.next().toUpperCase();

                switch (response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid Choice");
                }

            }
        }
        catch(FileNotFoundException e){
            System.out.println("Could not locate file");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio file is not supported");
        }
        catch(LineUnavailableException e){
            System.out.println("Unable to access audio resource");
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }
        finally{
            System.out.println("Bye!");
        }
    }

}
