import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//AudioPlayer in java 😁
public class HangedMan{
    public static void main(String[] args){
        //JAVA HANGED MANString filePath = "C:\\Users\\TOSHIBA\\Desktop\\uranus.txt";
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordList = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++){
            wordList.add('_');


        }
        System.out.println("***********************");
        System.out.println("Welcome to Java Hangman");
        System.out.println("***********************");

        while(wrongGuesses < 6){
            System.out.println(getHangman(wrongGuesses));


            System.out.println("word: ");

            for(char c : wordList){
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            System.out.println(guess);
            if (word.indexOf(guess) >= 0 ){
                System.out.println("Correct guess!");
                for(int i = 0; i < word.length();i++ ){
                    if(word.charAt(i) == guess){
                        wordList.set(i, guess);
                    }

                }
                if(!wordList.contains('_')){
                    System.out.println(getHangman(wrongGuesses));
                    System.out.println("you Win");
                    System.out.println("The word was: " + word);
                    break;

                }
            }
            else {
                System.out.println("Wrong Guess!");
                wrongGuesses += 1;
            }

        }
        if(wrongGuesses >= 6){
            System.out.println(getHangman(wrongGuesses));
            System.out.println("Game Over!");
            System.out.println("The word was: " + word);
        }


        scanner.close();
    }

    static String getHangman(int wrongGuesses){


        return switch(wrongGuesses){
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                     o
                     
                     
                     """;
            case 2 -> """
                     o
                     |
                    
                    """;
            case 3 -> """
                     o
                    /|
                    
                    """;
            case 4 -> """
                     o 
                    /|\\
                    
                    """;
            case 5 -> """
                     o
                    /|\\
                    /
                    """;
            case 6 -> """
                     o
                    /|\\
                    / \\
                    """;
            default -> "";
        };
    }

}
