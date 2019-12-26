/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.view;
import java.util.ArrayList;
import java.util.List;
import net.model.Lottery.*;
/**
 * View for Lottery 
 * @author Student
 */

//View
public class LotteryView {

    private String label2;
    private String label3;
    private String label4;
    private String label5;
    private String text1;
    private String text2;
    private String text3;
    private List<String> history;
    private int lotteriesCount;
    private String response;

    /**
     * View with informations which will be dispalyed in html site
     */
    public LotteryView(){
        label2 = "Amount of numbers";
        label3 = "Numbers limit";
        label4 = "Your numbers";
        label5 = "";
        text1 = "";
        text2 = "";
        text3 = "";
        history = new ArrayList<>();
        response = "";
        lotteriesCount = 0;

    }

    /**
     *
     * @param label2 Amount of numbers
     */
    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    /**
     *
     * @param label3 Numbers limit
     */
    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    /**
     *
     * @param label4 Users numbers
     */
    public void setLabel4(String label4) {
        this.label4 = label4;
    }

    /**
     *
     * @param label5 Error
     */
    public void setLabel5(String label5) {
        this.label5 = label5;
    }

    /**
     *
     * @param text1 Amount of numbers taken from site
     */
    public void setText1(String text1) {
        this.text1 = text1;
    }

    /**
     *
     * @param text2 Numbers limit taken from site
     */
    public void setText2(String text2) {
        this.text2 = text2;
    }

    /**
     *
     * @param text3 Users numbers taken from site
     */
    public void setText3(String text3) {
        this.text3 = text3;
    }

    /**
     *
     * @return respone
     */
    public String getResponse() {
        return response;
    }

    /**
     *
     * @param lotteriesCount How many lotteries was done in this session
     */
    public void setLotteriesCount(int lotteriesCount) {
        this.lotteriesCount = lotteriesCount;
    }

    /**
     *
     * @param newLottery String with information from lottery
     */
    public void addNewEntry(String newLottery)
    {
        if(history.size() >= 10)
        {
            history.remove(0);
        }
        history.add("<li>" + newLottery + "</li>");
    }

    /**
     * Clears history
     */
    public void clearHistory()
    {
        history.clear();
    }

    /**
     * Creates html responmse
     */
    public void createResponse()
    {
        String historyStr = "";
        for(String str: history)
        {
            historyStr += str;
        }
        response = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Lottery generator</title>\n"
                + "        <link rel=\"stylesheet\" href=\"styles.css\"> \n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div id=\"view\">\n"
                + "            <h3 id=\"label1\"> Welcome! Please complete fields below to start lottery. </h3>\n"
                + "            <h4 id=\"label2\">" + label2 + " </h4>\n"
                + "            <h4 id=\"label3\">" + label3 + "</h4>\n"
                +"             <h4 id=\"label4\">" + label4 + "</h4>\n"
                + "            <form action=\"Draw\" method=\"POST\">\n"
                + "                <input id=\"text1\" type=\"text\" value=\"" + text1 + "\" name=\"text1\">\n"
                + "                <input id=\"text2\" type=\"text\" value=\"" + text2 + "\"name=\"text2\">\n"
                + "                <input id=\"text3\" type=\"text\" value=\"" + text3 + "\"name=\"text3\">\n"
                + "                <input id=\"draw\" type=\"submit\" value=\"Draw\" />\n"
                + "            </form>\n"
                + "            <div id=\"error\">" + label5 + "</div>\n"
                + "            <h4 id=\"label6\">History of lotteries:</h4>\n"
                + "            <div id=\"history\">" + historyStr + "</div>\n"
                + "            <h3 id=\"cookie\"> You tried to win lottery " + lotteriesCount + " times.</h3>\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>\n";
    }

    
}
