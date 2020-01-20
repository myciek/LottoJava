package net.servlets;

import net.model.Lottery;
import net.view.LotteryView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class History
{
    private Connection connection;
    private LotteryView view;
    private Lottery lottery;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Object sessionLottery = session.getAttribute("lottery");
        Object sessionView = session.getAttribute("view");

        if (sessionLottery == null) {
            lottery = new Lottery();

        } else {
            lottery = (Lottery) sessionLottery;
        }
        if (sessionView == null) {
            view = new LotteryView();
        } else {
            view = (LotteryView) sessionView;
        }
        lottery.setHistory(getHistory(lottery,view));
        session.setAttribute("lottery", lottery);
        session.setAttribute("view", view);

    }

    private String getHistory(Lottery model, LotteryView view)
    {
        String history ="";
        if (connection == null) {
            Context initContext;
            try {
                initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/lotteryDB");
                connection = ds.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM lottery");

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {               
                history += "Amount of numbers: " + rs.getInt("amountOfNumbers") + "\n";
                history += "Numbers limit: " + rs.getInt("numbersLimit") + "\n";
                history+= "Your numbers: " + rs.getString("usersNumbers") + "\n";
                history+= "Numbers drawn: "+ rs.getString("drawnNumbers") + "\n";

                history+="You hit " + rs.getInt("numbersHit") + " numbers.\n";
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}
