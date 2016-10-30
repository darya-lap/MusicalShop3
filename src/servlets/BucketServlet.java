package servlets;

import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "BucketServlet", urlPatterns = "/BucketServlet")
public class BucketServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BucketContainer bc = BucketContainer.get(session);

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().contains("amount")) {
                String name = cookie.getName();
                int i = 0;
                if ((name.charAt(i) > '0') && (name.charAt(i) < '9')) {
                    while (name.charAt(i) != 'a') {
                        i++;
                    }
                    bc.addItem(Integer.parseInt(name.substring(0, i - 1)), Integer.parseInt(cookie.getValue()));
                }
            }
        }
        response.sendRedirect("/resources/JSP/bucket.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}