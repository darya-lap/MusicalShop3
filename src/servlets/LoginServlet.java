package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "POST requests are not supported");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            String user = request.getRemoteUser();
            session.setAttribute("user", user);
            String l = returnCookieLang(session,request);
            String p = "description";
            String s = getServletContext().getInitParameter("paramDesc");
            if (s.equals("none")){
                s = getServletContext().getInitParameter("paramDet");
                p="details";
                if (s.equals("none")){
                    s = getInitParameter("paramRev");
                    p="reviews";
                }
            }
            session.setAttribute("paramDef",p);
            response.sendRedirect("/resources/JSP/bucket.jsp?lang=" + l);
        }
        else{
            session.removeAttribute("user");
            String l=returnCookieLang(session,request);
            response.sendRedirect("/resources/JSP/listOfInstruments.jsp?lang="+l);
            session.invalidate();
        }
    }
}
