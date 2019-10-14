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
public class JavaApplication {

    /**
     * @param args the command line arguments
     * Firts argument should be number of numbers you want to bet.
     * Second argument is last number program can pick (from 1 to this number).
     * Next x arguments(x = first argument) should be numbers you want to bet.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numberOfNumbers = 0;
        List usersNumbers = new ArrayList();
        if(args.length >0)
        {
            numberOfNumbers = Integer.parseInt(args[0]);
            System.out.println("You picked "+ args[0]+ " numbers.");
            System.out.println("Victorious numbers will be higher then 1 and smaller than " + args[1]+".");
               
        
            for (int i = 2; i < numberOfNumbers + 2; i++) 
            {
                System.out.println("Your number: " + args[i]);
                usersNumbers.add(args[i]);
            }
        }
    }
    
}
