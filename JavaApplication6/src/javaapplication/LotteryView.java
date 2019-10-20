/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
import java.util.List;
/**
 *
 * @author Student
 */
public class LotteryView {
    
    public void printLotteryDetails(int amountOfNumbers, int numbersLimit, List usersNumbers, List drawnNumbers)
    {
        System.out.println("Lottery:");
        System.out.println(amountOfNumbers  + " numbers will be draw.");
        System.out.println("Victorious numbers will be higher then 1 and smaller than " + numbersLimit +".");
        System.out.println("You picked: ");
        for(int i =0; i< amountOfNumbers ; i++)
        {
            System.out.println(usersNumbers.get(i));
        }
        System.out.println("Numbers drawn: ");
        for(int i =0; i< amountOfNumbers ; i++)
        {
            System.out.println(drawnNumbers.get(i));
        }
    }
    
}
