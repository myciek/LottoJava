/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;
import java.util.List;
/**
 * View for Lottery 
 * @author Student
 */

//View
public class LotteryView {

    /**
     * Function that prints all properties of Lottery model
     * @param amountOfNumbers Amount of numbers user wants to bet
     * @param numbersLimit Numbers should be smaller than that number
     * @param usersNumbers Numbers given by user
     * @param drawnNumbers Numbers drawn
     * @param numbersHit  How many numbers user bet corectlly
     */
    public LotteryView(){};
    public void printLotteryDetails(int amountOfNumbers, int numbersLimit, List usersNumbers, List drawnNumbers, int numbersHit)
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
        System.out.println("You hit " + numbersHit + " numbers.");
    }
    
}
