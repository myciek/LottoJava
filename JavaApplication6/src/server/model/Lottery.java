/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import server.WrongArgumentsException;

/**
 * Model for Lottery application
 * @author Student
 */

public class Lottery {


    private int amountOfNumbers;
    private int numbersLimit;
    private List<Integer> usersNumbers = new ArrayList<>();
    private List<Integer> drawnNumbers = new ArrayList<>();
    private int numbersHit;

    private enum Result {
        lose,
        win;
    }

    private Result result;
    /**
     *
     * @return Amount of numbers user wants to bet
     */

    public int getAmountOfNumbers() {
        return amountOfNumbers;
    }

    /**
     *
     * @param amountOfNumbers  Amount of numbers user wants to bet
     */
    public void setAmountOfNumbers(int amountOfNumbers) {
        this.amountOfNumbers = amountOfNumbers;
    }

    /**
     *
     * @return Numbers should be smaller than that number
     */
    public int getNumbersLimit() {
        return numbersLimit;
    }

    /**
     *
     * @param numbersLimit -  Numbers should be smaller than that number
     */
    public void setNumbersLimit(int numbersLimit) {
        this.numbersLimit = numbersLimit;
    }

    /**
     *
     * @return Numbers given by user
     */
    public List getUsersNumbers() {
        return usersNumbers;
    }

    /**
     *
     * @param usersNumbers - Numbers given by user
     */
    public void setUsersNumbers(List usersNumbers) {
        this.usersNumbers = usersNumbers;
    }

    /**
     *
     * @return Numbers drawn
     */
    public List getDrawnNumbers() {
        return drawnNumbers;
    }

    /**
     *
     * @param drawnNumbers -  Numbers drawn
     */
    public void setDrawnNumbers(List drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    /**
     *
     * @return How many numbers user bet corectlly
     */
    public int getNumbersHit() {
        return numbersHit;
    }

    /**
     *
     * @param numbersHit How many numbers user bet corectlly
     */
    public void setNumbersHit(int numbersHit) {
        this.numbersHit = numbersHit;
    }   

    /**
     * Function that draw numbers based on amountOfNumbers and numbersLimit
     */
    public void drawNumbers() {
        ArrayList<Integer> allPossibleNumbers = new ArrayList<>();
        for (int i = 1; i < numbersLimit; i++) {
            allPossibleNumbers.add(i);
        }
        Collections.shuffle(allPossibleNumbers);
        for (int i = 0; i < amountOfNumbers; i++) {
            drawnNumbers.add(allPossibleNumbers.get(i));
        }
    }

    /**
     * Function that check how many numbers user picked were also drawn
     */
    public void numbersHit() {
        numbersHit = 0;
        result = Result.lose;
        for (int element : usersNumbers) {
            if (drawnNumbers.contains(element)) {
                System.out.println("Hit: " + String.valueOf(element));
                numbersHit++;
                result = Result.win;
            }
        }
        if (result == Result.win) {
            System.out.println("Nice!");            
        } else {
            System.out.println("Try again, no hits.");
        }
    }

    /**
     *
     * @deprecated
     */
    @Deprecated
    public void NumbersHits() {
        int numbersHit = 0;
        for (int i = 0; i < amountOfNumbers; i++) {
            if (drawnNumbers.contains(usersNumbers.get(i))) {
                System.out.println("Hit: " + usersNumbers.get(i));
                numbersHit++;
            }
        }
        System.out.println("You hit " + numbersHit + " numbers.");

    }

    // 

    /**
     * Exception handling and setting properties of Lottery model
     * @param args the command line arguments. First argument should be number of
     * numbers you want to bet. Second argument is last number program can pick
     * (from 1 to this number). Next x arguments(x = first argument) should be
     * numbers you want to bet.
     * @throws WrongArgumentsException exception throw when user gives wrong arguments
     */

    public void checkArguments(String[] args) throws WrongArgumentsException {
        amountOfNumbers = 0;
        numbersLimit = 0;

        if (args.length > 0)  {

            amountOfNumbers = Integer.parseInt(args[0]);
            if (amountOfNumbers < 1) {
                throw new WrongArgumentsException("Argument out of scope.");
            }

            numbersLimit = Integer.parseInt(args[1]);
            if (numbersLimit < 1 && args.length == Integer.parseInt(args[0]) + 2) {
                throw new WrongArgumentsException("Argument out of scope.");
            }
            for (int i = 2; i < amountOfNumbers + 2; i++) {
                if (Integer.parseInt(args[i]) < numbersLimit) {
                    usersNumbers.add(Integer.parseInt(args[i]));

                } else {
                    throw new WrongArgumentsException("Argument out of scope.");

                }

            }
        } else {

            throw new WrongArgumentsException("Bad arguments");
        }
    }

    public String printLotteryDetails()
    {
        String details = "Lottery: \n" + amountOfNumbers + " numbers will be draw.\n" + "Victorious numbers will be higher then 1 and smaller than " +numbersLimit + "\nYou picked: ";
        for(int i =0; i< amountOfNumbers ; i++)
        {
            details+=(usersNumbers.get(i)) + " ";
        }
        details+= "\nNumbers drawn: ";
        for(int i =0; i< amountOfNumbers ; i++)
        {
            details+=(drawnNumbers.get(i)) + " ";
        }
        details+= "\nYou hit " + numbersHit + " numbers.";
        return  details;
    }
}
