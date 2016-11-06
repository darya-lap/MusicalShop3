package servlets;

import ConnectToDB.Order;
import DAO.Factory1;
import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "RecordToDBServlet", urlPatterns = "/RecordToDBServlet")
public class RecordToDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        String d = sdf.format(new Date());

        BucketContainer bucketContainer = BucketContainer.get(session);
        LinkedHashMap<Integer,Integer> amount_id = bucketContainer.getId_amount();
        LinkedHashSet<Integer> ids = bucketContainer.getIds();

        for(Integer id:ids){
            Order order = new Order();
            order.setUser(session.getAttribute("user").toString());
            order.setInstrument_id(id);
            order.setAmount(amount_id.get(id));
            order.setCurDate(new Date());
            if (request.getParameter("courier")!= null) order.setCourier(request.getParameter("courier"));
            if (request.getParameter("shop")!=null) order.setShop(request.getParameter("shop"));
            try {
                Factory1.getInstance().getOrderDAO().setOrder(order);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        bucketContainer.clearFullCost();
        bucketContainer.getIds().clear();
        bucketContainer.getId_amount().clear();
        bucketContainer.getId_price().clear();
        String l=returnCookieLang(session,request);
        response.sendRedirect("/resources/JSP/endOfOrder.jsp?lang="+l);
    }
}
