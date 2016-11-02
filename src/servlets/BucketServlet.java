package servlets;

import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "BucketServlet", urlPatterns = "/BucketServlet")
public class BucketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BucketContainer bean = BucketContainer.get(session);

        String value =  request.getParameter("amountToBucket");
        String id1 = request.getParameter("id1");
        String d = request.getParameter("del");
        if (d != null){
            bean.getIds().clear();
            bean.getId_amount().clear();
            bean.getId_price().clear();
            bean.clearFullCost();
        }
        else {
            if (!value.equals("0")) {
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
        }

        response.sendRedirect("/resources/JSP/listOfInstruments.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}