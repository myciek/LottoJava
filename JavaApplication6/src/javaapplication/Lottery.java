/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Student
 */
// Model
public class Lottery {
//  Amount of numbers user wants to bet

    private int amountOfNumbers;
//  Numbers should be smaller than that number
    private int numbersLimit;
// Numbers given by user
    private List<Integer> usersNumbers = new ArrayList<>();
// Numbers drawn
    private List<Integer> drawnNumbers = new ArrayList<>();
    private int numbersHit;

    private enum Result {

        lose,
        win;
    }

    private Result result;

    // Functions to get and set properties of Lottery

    public int getAmountOfNumbers() {
        return amountOfNumbers;
    }

    public void setAmountOfNumbers(int amountOfNumbers) {
        this.amountOfNumbers = amountOfNumbers;
    }

    public int getNumbersLimit() {
        return numbersLimit;
    }

    public void setNumbersLimit(int numbersLimit) {
        this.numbersLimit = numbersLimit;
    }

    public List getUsersNumbers() {
        return usersNumbers;
    }

    public void setUsersNumbers(List usersNumbers) {
        this.usersNumbers = usersNumbers;
    }

    public List getDrawnNumbers() {
        return drawnNumbers;
    }

    public void setDrawnNumbers(List drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    public int getNumbersHit() {
        return numbersHit;
    }

    public void setNumbersHit(int numbersHit) {
        this.numbersHit = numbersHit;
    }

// Function that draw numbers based on amountOfNumbers and numbersLimit    
    public void DrawNumbers() {
        ArrayList<Integer> allPossibleNumbers = new ArrayList<>();
        for (int i = 1; i < numbersLimit; i++) {
            allPossibleNumbers.add(i);
        }
        Collections.shuffle(allPossibleNumbers);
        for (int i = 0; i < amountOfNumbers; i++) {
            drawnNumbers.add(allPossibleNumbers.get(i));
        }
    }
// Function that check how many numbers user picks were also drawn

    public void NumbersHit() {
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
            System.out.println("You hit " + numbersHit + " numbers.");
        } else {
            System.out.println("Try again, no hits.");
        }
    }

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

    // Exception handling and setting properties of Lottery model

    public void CheckArguments(String[] args) throws WrongArgumentsException {
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
