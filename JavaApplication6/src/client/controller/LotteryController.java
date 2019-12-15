/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import server.model.Lottery;
import java.util.List;

import server.WrongArgumentsException;
import client.view.*;

/**
 * Controller for Lottery application
 * @author Student
 */


public class LotteryController {

    private Lottery model;
    private LotteryView view;

    /**
     * Contructor
     * @param model - Lottery model
     * @param view - LotteryView view
     */
    public LotteryController(Lottery model, LotteryView view) {
        this.model = model;
        this.view = view;
    }
    public LotteryController(LotteryView view)
    {
        this.view = view;
    }

    /**
     *
     * @param amountOfNumbers Amount of numbers user wants to bet
     */
     
    public void setLotteryAmountOfNumbers(int amountOfNumbers) {
        model.setAmountOfNumbers(amountOfNumbers);
    }

    /**
     *
     * @return Amount of numbers user wants to bet
     */
    public int gettLotteryAmountOfNumbers() {
        return model.getAmountOfNumbers();
    }

    /**
     *
     * @param numbersLimit Numbers should be smaller than that number
     */
    public void setLotteryNumbersLimit(int numbersLimit) {
        model.setNumbersLimit(numbersLimit);
    }

    /**
     *
     * @return Numbers should be smaller than that number
     */
    public int getLotteryNumbersLimit() {
        return model.getNumbersLimit();
    }

    /**
     *
     * @param usersNumbers Numbers given by user
     */
    public void setLotteryUsersfNumbers(List usersNumbers) {
        model.setUsersNumbers(usersNumbers);
    }

    /**
     *
     * @return Numbers given by user
     */
    public List getLotteryUsersNumbers() {
        return model.getUsersNumbers();
    }

    /**
     *
     * @param drawnNumbers Numbers drawn
     */
    public void setLotteryDrawnNumbers(List drawnNumbers) {
        model.setDrawnNumbers(drawnNumbers);
    }

    /**
     *
     * @return Numbers drawn
     */
    public List getLotterytDrawnNumbers() {
        return model.getDrawnNumbers();
    }
    
    /**
     *
     * @return How many numbers user bet corectlly
     */
    public int getLotteryNumbersHit() {
        return model.getNumbersHit();
    }

    /**
     *
     * @param numbersHit - How many numbers user bet corectlly
     */
    public void setLotteryNumbersHit(int numbersHit) {
        model.setNumbersHit(numbersHit);
    }   



    /**
     *Function that draw numbers
     */
    public void LotteryDrawnNumbers() {
        model.drawNumbers();
    }
    
    /**
     * Exception handling and setting properties of Lottery model
     * @param args the command line arguments. Firts argument should be number of
     * numbers you want to bet. Second argument is last number program can pick
     * (from 1 to this number). Next x arguments(x = first argument) should be
     * numbers you want to bet.
     */
    public void LotteryCheckArguments(String[] args)
    {
        try{
        model.checkArguments(args);
        }catch(WrongArgumentsException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
   

}
