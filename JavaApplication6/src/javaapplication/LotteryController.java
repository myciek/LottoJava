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

//Controller
public class LotteryController {
    
    //Model
    private Lottery model;
    //View
    private LotteryView view;

    //Contructor
    public LotteryController(Lottery model, LotteryView view) {
        this.model = model;
        this.view = view;
    }
    // Functions to get and set properties of Lottery
    public void setLotteryAmountOfNumbers(int amountOfNumbers) {
        model.setAmountOfNumbers(amountOfNumbers);
    }

    public int gettLotteryAmountOfNumbers() {
        return model.getAmountOfNumbers();
    }

    public void setLotteryNumbersLimit(int numbersLimit) {
        model.setNumbersLimit(numbersLimit);
    }

    public int getLotteryNumbersLimit() {
        return model.getNumbersLimit();
    }

    public void setLotteryUsersfNumbers(List usersNumbers) {
        model.setUsersNumbers(usersNumbers);
    }

    public List getLotteryUsersNumbers() {
        return model.getUsersNumbers();
    }

    public void setLotteryDrawnNumbers(List drawnNumbers) {
        model.setDrawnNumbers(drawnNumbers);
    }

    public List getLotterytDrawnNumbers() {
        return model.getDrawnNumbers();
    }
    
    // Function that update view and checks if users hit any numbers
    public void updateView() {
        view.printLotteryDetails(model.getAmountOfNumbers(), model.getNumbersLimit(), model.getUsersNumbers(), model.getDrawnNumbers());
        model.NumbersHit();
    }
    
    // Function that draw numbers
    public void LotteryDrawnNumbers() {
        model.DrawNumbers();
    }
    
    public void LotteryCheckArguments(String[] args)
    {
        try{
        model.CheckArguments(args);
        }catch(WrongArgumentsException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
   

}
