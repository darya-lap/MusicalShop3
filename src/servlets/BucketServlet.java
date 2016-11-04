package servlets;

import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static workWithServletes.addItemToBean.addItemToBean;
import static workWithServletes.returnCookieLang.returnCookieLang;

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
                addItemToBean(id1,value,bean);
            }
        }


        String l=returnCookieLang(session,request);
        response.sendRedirect("/resources/JSP/listOfInstruments.jsp?lang="+l);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}