package servlets;

import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "BucketServlet1", urlPatterns = "/BucketServlet1")
public class BucketServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BucketContainer bean = BucketContainer.get(session);

        String value = "1";
        String id1 = request.getParameter("id1");
        if (id1 != null) {
            int i = 0;
            while (id1.charAt(i) != '&') {
                i++;
            }
            String id = id1.substring(0, i);
            String price = id1.substring(i + 1);
            if (value != null) {
                bean.addItem(Integer.parseInt(id), Integer.parseInt(value));
                bean.addId(Integer.parseInt(id));
                bean.addItemPr(Integer.parseInt(id), Integer.parseInt(price));
            }
        }

        response.sendRedirect("/resources/JSP/bucket.jsp?lang="+session.getAttribute("lang").toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}
