package servlets;

import DAO.Factory1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
    try {
        List<Integer> number = Factory1.getInstance().getShopDAO().getAllShopsNumbers();
        List<Float> lat = Factory1.getInstance().getShopDAO().getAllShopsLat();
        List<Float> lng = Factory1.getInstance().getShopDAO().getAllShopsLng();
        List<String> name = Factory1.getInstance().getShopDAO().getAllShopsNames();

        session.setAttribute("lat", lat.toString());
        session.setAttribute("lng", lng.toString());
        session.setAttribute("name", name.toString());
        session.setAttribute("amountOfShops", number.size());
        session.setAttribute("id_shop", number.toString());

    }
    catch (SQLException e){
        e.printStackTrace();
    }

        String l=returnCookieLang(session,request);
        response.sendRedirect("/resources/JSP/order.jsp?lang="+l);
    }
}
