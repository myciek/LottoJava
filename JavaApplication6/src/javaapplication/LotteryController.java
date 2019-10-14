/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

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
        
    }
}
