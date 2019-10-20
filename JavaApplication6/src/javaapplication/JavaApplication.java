/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class JavaApplication {

    /**
     * @param args the command line arguments
     * Firts argument should be number of numbers you want to bet.
     * Second argument is last number program can pick (from 1 to this number).
     * Next x arguments(x = first argument) should be numbers you want to bet.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int amountOfNumbers  = 0;
        int numbersLimit = 0;
        List usersNumbers = new ArrayList();
        if(args.length >0)
        {
            if(args.length == Integer.parseInt(args[0] )+ 2)
            {
                amountOfNumbers  = Integer.parseInt(args[0]);
                System.out.println("You picked "+ amountOfNumbers + " numbers.");
                numbersLimit = Integer.parseInt(args[1]);
                System.out.println("Victorious numbers will be higher then 0 and smaller than " + numbersLimit +".");


                for (int i = 2; i < amountOfNumbers  + 2; i++) 
                {
                    System.out.println("Your number: " + args[i]);
                    usersNumbers.add(args[i]);
                }     
            }
            else
            {
                Scanner input = new Scanner(System.in);
                System.out.println("How many numbers you want to bet?");
                amountOfNumbers = input.nextInt();
                System.out.println("From what number they have to be smaller?");
                numbersLimit = input.nextInt();
                
                for (int i = 0; i < amountOfNumbers; i++) 
                {
                    System.out.println("Pick number: ");
                    usersNumbers.add(input.nextInt());
                }     
            }
            
            Lottery model = new Lottery();
            LotteryView view = new LotteryView();
            LotteryController controller = new LotteryController(model,view);
            
            controller.setLotteryAmountOfNumbers(amountOfNumbers);
            controller.setLotteryNumbersLimit(numbersLimit);
            controller.setLotteryUsersfNumbers(usersNumbers);
            controller.LotteryDrawnNumbers();
            controller.updateView();
            
           
        }
    }
    
}
