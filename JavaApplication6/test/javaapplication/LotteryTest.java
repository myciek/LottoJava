/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import javaapplication.model.Lottery;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Lottery application
 * @author Maciek
 */
public class LotteryTest {

    /**
     * Test that check if numbers are hit correctly
     */
    @Test
    public void testNumbersHit() {
        Lottery lottery = new Lottery();
        List<Integer> usersNumbers = new ArrayList<>();
        List<Integer> drawnNumbers = new ArrayList<>();
        usersNumbers.add(3);
        drawnNumbers.add(5);
        lottery.setUsersNumbers(usersNumbers);
        lottery.setDrawnNumbers(drawnNumbers);
        lottery.numbersHit();
        assertEquals("Numbers hit should be 0.", lottery.getNumbersHit(), 0);

        drawnNumbers.add(3);
        lottery.setUsersNumbers(usersNumbers);
        lottery.setDrawnNumbers(drawnNumbers);
        lottery.numbersHit();
        assertEquals("Numbers hit should be 1.", lottery.getNumbersHit(), 1);

    }

    /**
     * Test that checks if program handle wrong arguments 
     */
    @Test
    public void testCheckArguments() {
        Lottery lottery = new Lottery();        
        List<Integer> usersNumbers = new ArrayList<>();
        usersNumbers.add(1);
        usersNumbers.add(2);
        usersNumbers.add(3);
        try {
            String args[] = {"3", "9", "1", "2", "3"};
            lottery.checkArguments(args);
            assertEquals("Amount of numbers should be 3.", lottery.getAmountOfNumbers(), 3);
            assertEquals("Maximum number should be 9.", lottery.getNumbersLimit(), 9);
            assertEquals("Users numbers should be (1,2,3).", lottery.getUsersNumbers(), usersNumbers);
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            String args[] = {"1", "9", "1"};
            lottery.checkArguments(args);
            assertEquals("Amount of numbers should be 1.", lottery.getAmountOfNumbers(), 1);
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            String args[] = {"3", "1", "1", "2", "3"};
            lottery.checkArguments(args);
            assertEquals("Maximum number should be 1.", lottery.getNumbersLimit(), 1);
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            String args[] = {"3", "3", "2", "1", "8"};
            lottery.checkArguments(args);
            fail("For argument out of scope exception should be thrown");
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            String args[] = {"-1", "3", "2", "1", "1"};
            lottery.checkArguments(args);
            fail("For argument out of scope exception should be thrown");
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            String args[] = {"3", "0", "2", "1", "8"};
            lottery.checkArguments(args);
            fail("For argument out of scope exception should be thrown");
        } catch (WrongArgumentsException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
