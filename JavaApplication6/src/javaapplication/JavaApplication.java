/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import javaapplication.controller.LotteryController;
import javaapplication.view.LotteryView;
import javaapplication.model.Lottery;

/**
 * Main file of Lottery application
 * @author Student
 */
public class JavaApplication {

    /**
     * @param args the command line arguments.Firts argument should be number of
     * numbers you want to bet. Second argument is last number program can pick
     * (from 1 to this number). Next x arguments(x = first argument) should be
     * numbers you want to bet.
     */
    public static void main(String[] args) {
        
        Lottery model = new Lottery();
        LotteryView view = new LotteryView();
        LotteryController controller = new LotteryController(model, view);
        controller.LotteryCheckArguments(args);
        controller.LotteryDrawnNumbers();
        controller.updateView();

    }
}

