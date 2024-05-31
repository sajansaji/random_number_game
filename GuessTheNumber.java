// Title of the project 01: Number Guessing Game
import java.util.Random;
import java.util.Scanner;
public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(10) + 1;
        Scanner scanner = new Scanner(System.in);
       
        for (int i = 0; i < 5; i++) {
            System.out.print("\nEnter your guess: ");
int g = scanner.nextInt();
            if (g == num) {
                if((4-i)==1){
                   System.out.println("Your Score is : 200"); 
                }
             else if((4-i)==2){
                   System.out.println("Your Score is : 300"); 
                }
            else if((4-i)==3){
                   System.out.println("Your Score is : 400"); 
                }
            else if((4-i)==0){
                  System.out.println("Better luck, next time !"); 
                }
            else{
                System.out.println("Your Score is : 500");
                }
                System.out.println("You are right.");
                break;
            } else if (g > num) {
                System.out.println("High.\n");
            } else {
                System.out.println("low.\n");
            }
            System.out.println("Remaining guess: " + (4 - i));
}
        System.out.println("Number generated is: " + num);
    }
}