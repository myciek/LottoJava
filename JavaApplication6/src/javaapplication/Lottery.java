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
public class Lottery {
    private int numberOfNumbers;
    private List usersNumbers = new ArrayList();
    private List drawnNumbers = new ArrayList();
    
    public int getNumberOfNumbers()
    {
        return numberOfNumbers;
    }
    
    public void setNumberOfNumbers(int numberOfNumbers)
    {
        this.numberOfNumbers = numberOfNumbers;
    }
    
    public List getUsersNumbers()
    {
        return usersNumbers;
    }
    
    public void setUsersNumbers(List usersNumbers)
    {
        this.usersNumbers = usersNumbers;
    }
    
    public List getDrawnNumbers()
    {
        return drawnNumbers;
    }
    
    public void setDrawnNumbers(List drawnNumbers)
    {
        this.drawnNumbers = drawnNumbers;
    }
}
