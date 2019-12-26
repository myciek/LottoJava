/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import net.exceptions.WrongArgumentsException;

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
    private List<String> history;

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

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public String createNewEntry()
    {
        String entry = "";
        entry += "Amount of numbers: " + amountOfNumbers + "\n";
        entry += "Numbers limit: " + numbersLimit + "\n";
        entry+= "Your numbers: ";
        for(int number: usersNumbers)
        {
            entry+= number + " ";
        }
        entry+= "\nNumbers drawn: ";
        for(int number: drawnNumbers)
        {
            entry+= number + " ";
        }
        entry+="\nYou hit " + numbersHit + " numbers.\n";

        return entry;
    }

    public void clearHistory()
    {
        history.clear();
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

    public void checkArguments(ArrayList<String> args) throws WrongArgumentsException {
        amountOfNumbers = 0;
        numbersLimit = 0;

        if (args.size() > 0)  {

            amountOfNumbers = Integer.parseInt(args.get(0));
            if (amountOfNumbers < 1) {
                throw new WrongArgumentsException("Argument out of scope.");
            }

            numbersLimit = Integer.parseInt(args.get(1));
            if (numbersLimit < 1 && args.size() == Integer.parseInt(args.get(0)) + 2) {
                throw new WrongArgumentsException("Argument out of scope.");
            }
            for (int i = 2; i < amountOfNumbers + 2; i++) {
                if (Integer.parseInt(args.get(i)) < numbersLimit) {
                    usersNumbers.add(Integer.parseInt(args.get(i)));

                } else {
                    throw new WrongArgumentsException("Argument out of scope.");

                }

            }
        } else {

            Scanner input = new Scanner(System.in);
            System.out.println("How many numbers you want to bet?");
            amountOfNumbers = input.nextInt();
            if (amountOfNumbers < 1) {
                throw new WrongArgumentsException("Argument out of scope.");
            }

            System.out.println("From what number they have to be smaller?");
            numbersLimit = input.nextInt();

            if (numbersLimit < 1) {
                throw new WrongArgumentsException("Argument out of scope.");
            }

            for (int i = 0; i < amountOfNumbers; i++) {
                System.out.println("Pick number: ");
                int number = input.nextInt();
                if (number < numbersLimit) {
                    usersNumbers.add(number);
                } else {
                    throw new WrongArgumentsException("Argument out of scope.");

                }
            }
        }
    }
}
