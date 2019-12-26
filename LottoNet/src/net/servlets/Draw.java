package net.servlets;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.swing.text.View;

public class Draw extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Lottery lottery;
        LotteryView view;
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

        useCookies(view,request,response);
        ArrayList<String> args = new ArrayList<String>();
        args.add(request.getParameter("text1"));
        args.add(request.getParameter("text1"));
        String numbers[] = request.getParameter("text1").split(",");
        for(String number:numbers)
        {
            args.add(number);
        }
        this.draw(lottery,view,args);
        try(PrintWriter out = response.getWriter())
        {
            view.createResponse();
            out.println(view.getResponse());
        }
        session.setAttribute("lottery",lottery);
        session.setAttribute("view",view);

    }

    private void draw(Lottery lottery, LotteryView view, ArrayList<String> args)
    {
        String newEntry;
        try
        {
            lottery.checkArguments(args);
            lottery.drawNumbers();
            lottery.numbersHit();
            newEntry  = lottery.createNewEntry();
        }
        catch (WrongArgumentsException e)
        {
            view.setLabel5(e.getMessage());
            newEntry = e.getMessage();
        }
        view.addNewEntry(newEntry);
    }

    private void useCookies(LotteryView view, HttpServletRequest request, HttpServletResponse response)
    {
        int lotteriesCount = 0;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies)
        {
            if(cookie.getName().equals("lotteries"))
            {
                lotteriesCount = Integer.parseInt(cookie.getValue());
            }
        }
        view.setLotteriesCount(lotteriesCount);
        lotteriesCount++;
        Cookie cookie = new Cookie("lotteries", String.valueOf(lotteriesCount));
        response.addCookie(cookie);
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
