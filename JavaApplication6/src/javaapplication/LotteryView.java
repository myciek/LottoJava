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
    
    public void printLotteryDetails(int numberOfNumbers, List usersNumbers, List drawnNumbers)
    {
        System.out.println("Lottery:");
        System.out.println(numberOfNumbers + " will be draw.");
        System.out.println("You picked: ");
        for(int i =0; i< numberOfNumbers; i++)
        {
            System.out.println(usersNumbers.get(i));
        }
        System.out.println("Numbers drawn: ");
        for(int i =0; i< numberOfNumbers; i++)
        {
            System.out.println(drawnNumbers.get(i));
        }
    }
    
}
