package servlets;

import DAO.Factory1;
import MyContainer.OrderContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderContainer order = OrderContainer.get(session);
        String l=returnCookieLang(session,request);
        ResourceBundle bundle = ResourceBundle.getBundle("prop", new Locale(l)) ;
    try {
        order.setNumber(Factory1.getInstance().getShopDAO().getAllShopsNumbers().toString());
        order.setLat(Factory1.getInstance().getShopDAO().getAllShopsLat().toString());
        order.setLat(order.getLat().substring(1,order.getLat().length()-1));
        order.setLng(Factory1.getInstance().getShopDAO().getAllShopsLng().toString());
        order.setLng(order.getLng().substring(1,order.getLng().length()-1));
        order.setNames(Factory1.getInstance().getShopDAO().getAllShopsNames().toString());
        order.setNames(order.getNames().substring(1,order.getNames().length()-1));
        order.setAmount_of_shops(Factory1.getInstance().getShopDAO().getAllShopsNumbers().size());
        List<Integer> ids = Factory1.getInstance().getShopDAO().getAllShopsNumbers();
        order.setIds(ids);
        order.setNames_array(Factory1.getInstance().getShopDAO().getAllShopsNames());
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < Factory1.getInstance().getShopDAO().getAllShopsNumbers().size();i++){
            order.getCount().add(i);
        }
        for (Integer i:ids){
            str.append(bundle.getString(i.toString()));
            str.append("; ");
        }
        order.setSecretMessage(str.toString());
    }
    catch (SQLException e){
        e.printStackTrace();
    }

        response.sendRedirect("/resources/JSP/order.jsp?lang="+l);
    }
}
