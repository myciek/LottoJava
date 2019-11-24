/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *Custom exception to work with arguments
 * @author Maciek
 */

public class WrongArgumentsException
     extends Exception {

    /**
     * Throw when arguments are incorrect
     * @param errorMessage - Message that describe error
     */
    public WrongArgumentsException(String errorMessage) {
        super(errorMessage);
    }
    
}
