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
public class LotteryController {

    private Lottery model;
    private LotteryView view;

    public LotteryController(Lottery model, LotteryView view) {
        this.model = model;
        this.view = view;
    }

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

    public void updateView() {
        view.printLotteryDetails(model.getAmountOfNumbers(), model.getNumbersLimit(), model.getUsersNumbers(), model.getDrawnNumbers());
        model.NumbersHit();
    }

    public void LotteryDrawnNumbers() {
        model.DrawNumbers();
    }

    public void CheckArguments(String[] args) {
        int amountOfNumbers = 0;
        int numbersLimit = 0;
        List usersNumbers = new ArrayList();
        try {

            if (args.length > 0) {
                if (args.length != Integer.parseInt(args[0]) + 2) {
                    throw new WrongArgumentsException("Wrong amount of arguments, you have to give it manually.");
                }
            } else {
                throw new WrongArgumentsException("Wrong amount of arguments, you have to give it manually.");
            }
            amountOfNumbers = Integer.parseInt(args[0]);
            numbersLimit = Integer.parseInt(args[1]);
            for (int i = 2; i < amountOfNumbers + 2; i++) {
                usersNumbers.add(args[i]);
            }
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
            Scanner input = new Scanner(System.in);
            System.out.println("How many numbers you want to bet?");
            amountOfNumbers = input.nextInt();
            System.out.println("From what number they have to be smaller?");
            numbersLimit = input.nextInt();

            for (int i = 0; i < amountOfNumbers; i++) {
                System.out.println("Pick number: ");
                usersNumbers.add(input.nextInt());
            }
        }

        setLotteryAmountOfNumbers(amountOfNumbers);
        setLotteryNumbersLimit(numbersLimit);
        setLotteryUsersfNumbers(usersNumbers);
    }

}
