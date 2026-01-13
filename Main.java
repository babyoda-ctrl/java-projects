import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 100;
        double bet;
        double payout;
        String[] row;
        String playAgain;

        System.out.println("************************");
        System.out.println("Welcome to slots in java");
        System.out.println("symbols: 🍒 ⭐ 🔔 🍉 🍋");
        System.out.println("************************");


        while (balance > 0) {
            System.out.println("current balance: $" + balance);
            System.out.print("how much would you like to bet? ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > balance) {
                System.out.println("INSUFFICIENT FUNDS");
                continue;
            } else if (bet <= 0) {
                System.out.println("BETS CANNOT BE 0 DOLLARS OR LESS");
                continue;
            } else {
                balance -= bet;
                System.out.println("balance: $" + balance);
                System.out.println("spinning...");
                row = spinRow();
                payout = getPayout(row,bet);

                if(payout > 0){
                    System.out.println("*****************************");
                    System.out.println("✨🍾✨🤑💸JACKPOT💸🤑✨🍾✨");
                    System.out.println(     "You won $" + payout      );
                    System.out.println("*****************************");
                    balance += payout;
                    System.out.println("your balance is $" + balance);


                }
                else {
                    System.out.println("Better luck next time ");
                }
                if (balance <= 0) {
                    System.out.println("You're out of money! Game over.");
                    break;
                }
                System.out.println("Do you want to play again(Y/N)? ");
                    playAgain = scanner.nextLine().toUpperCase();

                    if (!playAgain.equals("Y")) {
                        System.out.println("Thank you for playing! Final balance: $ " + balance);
                        break;
                    }
            }
        }

        scanner.close();
    }
     static String[] spinRow(){
        String[] symbol = {"🍒","⭐","🔔","🍉","🍋"};
        String[] row = new String[3];
        Random random = new Random();

        for(int i = 0 ; i < 3 ; i++){
            row[i] = symbol[random.nextInt(symbol.length)];

        }
         System.out.println("*************");
         System.out.println(row[0] + " | " + row[1] + " | " + row[2]);
         System.out.println("*************");

        return row;
     }
     static double getPayout(String[] row, double bet){

        if((row[0].equals(row[1]) && (row[1].equals(row[2])))){
            return switch(row[0]){
                case "🍒" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🍉" -> bet * 5;
                case "🔔" -> bet * 10;
                case "⭐" -> bet * 30;
                default -> 0;
            };
        }
        else if((row[0].equals(row[1]))
                || (row[1].equals(row[2]))
                || (row[0].equals(row[2]))){
            String matchedSymbol;
            if (row[0].equals(row[1]) || row[0].equals(row[2])) {
                matchedSymbol = row[0];
            } else {
                matchedSymbol = row[1];
            }
            return switch (row[0]) {
                case "🍒" -> bet * 2;
                case "🍋" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }
        return (0);
     }

}