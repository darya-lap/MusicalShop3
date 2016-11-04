package servlets;

import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static workWithServletes.addItemToBean.addItemToBean;
import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "BucketServlet1", urlPatterns = "/BucketServlet1")
public class BucketServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BucketContainer bean = BucketContainer.get(session);

        String value = "1";
        String id1 = request.getParameter("id1");
        if (id1 != null) {
            addItemToBean(id1,value,bean);
        }

        String l = returnCookieLang(session,request);
        response.sendRedirect("/resources/JSP/bucket.jsp?lang="+l);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}
