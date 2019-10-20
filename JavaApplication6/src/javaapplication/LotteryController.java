/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Student
 */
public class LotteryController {
    private Lottery model;
    private LotteryView view;
    
    public LotteryController(Lottery model, LotteryView view)
    {
        this.model = model;
        this.view = view;
    }
    
    public void setLotteryAmountOfNumbers(int amountOfNumbers)
    {
        model.setAmountOfNumbers(amountOfNumbers);
    }
    
    public int gettLotteryAmountOfNumbers()
    {
        return model.getAmountOfNumbers();
    }  
    
    public void setLotteryNumbersLimit(int numbersLimit)
    {
        model.setNumbersLimit(numbersLimit);
    }
    
    public int getLotteryNumbersLimit()
    {
        return model.getNumbersLimit();
    }
    public void setLotteryUsersfNumbers(List usersNumbers)
    {
        model.setUsersNumbers(usersNumbers);
    }
    
    public List getLotteryUsersNumbers()
    {
        return model.getUsersNumbers();
    }  
    
    public void setLotteryDrawnNumbers(List drawnNumbers)
    {
        model.setDrawnNumbers(drawnNumbers);
    }
    
    public List getLotterytDrawnNumbers()
    {
        return model.getDrawnNumbers();
    }  
    
    public void updateView()
    {
        view.printLotteryDetails(model.getAmountOfNumbers(),model.getNumbersLimit(), model.getUsersNumbers(), model.getDrawnNumbers());
        model.NumbersHit();
    }
    
    
    public void LotteryDrawnNumbers()
    {
        model.DrawNumbers();
    }
}
