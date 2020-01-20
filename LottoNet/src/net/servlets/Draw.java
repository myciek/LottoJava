package net.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.exceptions.WrongArgumentsException;
import net.model.Lottery;
import net.view.LotteryView;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class Draw extends HttpServlet {

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

        useCookies(view, request, response);
        ArrayList<String> args = new ArrayList<String>();
        args.add(request.getParameter("text1"));
        args.add(request.getParameter("text1"));
        String numbers[] = request.getParameter("text1").split(",");
        for (String number : numbers) {
            args.add(number);
        }
        this.draw(lottery, view, args);
        try (PrintWriter out = response.getWriter()) {
            view.createResponse();
            out.println(view.getResponse());
        }
        session.setAttribute("lottery", lottery);
        session.setAttribute("view", view);

    }

    private void draw(Lottery lottery, LotteryView view, ArrayList<String> args) {
        try {
            lottery.checkArguments(args);
            lottery.drawNumbers();
            lottery.numbersHit();
        } catch (WrongArgumentsException e) {
            view.setLabel5(e.getMessage());

        }
        insertData(lottery);
    }

    private void useCookies(LotteryView view, HttpServletRequest request, HttpServletResponse response) {
        int lotteriesCount = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lotteries")) {
                lotteriesCount = Integer.parseInt(cookie.getValue());
            }
        }
        view.setLotteriesCount(lotteriesCount);
        lotteriesCount++;
        Cookie cookie = new Cookie("lotteries", String.valueOf(lotteriesCount));
        response.addCookie(cookie);
    }

    private void insertData(Lottery model) {
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
                    "Insert into lottery (amountOfNumbers,numbersLimit,usersNumbers,drawnNumbers) values (?,?,?)");

            stmt.setString(1, Integer.toString(model.getAmountOfNumbers()));
            stmt.setString(2, Integer.toString(model.getNumbersLimit()));
            stmt.setString(3, model.getUsersNumbers().toString());
            stmt.setString(4, model.getDrawnNumbers().toString());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
