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
public class Lottery {
    private int amountOfNumbers ;
    private int numbersLimit;
    private List usersNumbers = new ArrayList();
    private List drawnNumbers = new ArrayList();
    
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
    
    public void DrawNumbers()
    {
      ArrayList allPossibleNumbers =  new ArrayList<Integer>();
      for(int i=0; i < numbersLimit; i++)
      {
          allPossibleNumbers.add(i);
      }
      Collections.shuffle(allPossibleNumbers);
      for(int i=0; i <amountOfNumbers;i++)
      {
          drawnNumbers.add(allPossibleNumbers.get(i));
      }
    }
    public void NumbersHit()
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
