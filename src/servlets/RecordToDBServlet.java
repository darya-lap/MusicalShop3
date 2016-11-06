package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "RecordToDBServlet", urlPatterns = "/RecordToDBServlet")
public class RecordToDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        Object h = session.getAttribute("user");
        h = request.getParameter("courier");
        h = request.getAttribute("courier");
        h = request.getParameter("shop");
        h = request.getAttribute("shop");

        String l=returnCookieLang(session,request);
        response.sendRedirect("/resources/JSP/order.jsp?lang="+l);
    }

}
