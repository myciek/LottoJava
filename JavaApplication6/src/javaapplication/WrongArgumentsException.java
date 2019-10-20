/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *
 * @author Maciek
 */
public class WrongArgumentsException
     extends Exception {
        public WrongArgumentsException(String errorMessage) {
        super(errorMessage);
    }
    
}
