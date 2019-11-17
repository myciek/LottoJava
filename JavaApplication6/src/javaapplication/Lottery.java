/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Student
 */

// Model
public class Lottery {
//  Amount of numbers user wants to bet
    private int amountOfNumbers ;
//  Numbers should be smaller than that number
    private int numbersLimit;
// Numbers given by user
    private List <Integer> usersNumbers = new ArrayList<>();
// Numbers drawn
    private List <Integer>drawnNumbers = new ArrayList<>();
 // Functions to get and set properties of Lottery
    public int getAmountOfNumbers ()
    {
        return amountOfNumbers ;
    }
    
    public void setAmountOfNumbers (int amountOfNumbers )
    {
        this.amountOfNumbers  = amountOfNumbers ;
    }
    
    public int getNumbersLimit()
    {
        return numbersLimit;
    }
    
    public void setNumbersLimit(int numbersLimit)
    {
        this.numbersLimit = numbersLimit;
    }
    
    public List getUsersNumbers()
    {
        return usersNumbers;
    }
    
    public void setUsersNumbers(List usersNumbers)
    {
        this.usersNumbers = usersNumbers;
    }
    
    public List getDrawnNumbers()
    {
        return drawnNumbers;
    }
    
    public void setDrawnNumbers(List drawnNumbers)
    {
        this.drawnNumbers = drawnNumbers;
    }
// Function that draw numbers based on amountOfNumbers and numbersLimit    
    public void DrawNumbers()
    {
      ArrayList<Integer> allPossibleNumbers =  new ArrayList<>();
      for(int i=1; i < numbersLimit; i++)
      {
          allPossibleNumbers.add(i);
      }
      Collections.shuffle(allPossibleNumbers);
      for(int i=0; i <amountOfNumbers;i++)
      {
          drawnNumbers.add(allPossibleNumbers.get(i));
      }
    }
// Function that check how many numbers user picks were also drawn
    public void NumbersHit()
    {
        int numbersHit = 0;
        for(int element:usersNumbers)
        {
            if(drawnNumbers.contains(element))
            {
                System.out.println("Hit: " + String.valueOf(element));
                numbersHit++;
            }
        }
        System.out.println("You hit " + numbersHit + " numbers.");

    }
    
    @Deprecated
    public void NumbersHits()
    {
        int numbersHit = 0;
        for(int i=0; i<amountOfNumbers; i++)
        {
            if(drawnNumbers.contains(usersNumbers.get(i)))
            {
                System.out.println("Hit: " + usersNumbers.get(i));
                numbersHit++;
            }
        }
        System.out.println("You hit " + numbersHit + " numbers.");

    }
}
