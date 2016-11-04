package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static workWithServletes.returnCookieLang.returnCookieLang;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

       /* Session session1 = null;
        Transaction tx = null;
        try {
            session1 = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session1.beginTransaction();
            ArrayList<Integer> number = new ArrayList<>();
            ArrayList<Float> lat = new ArrayList<>();
            ArrayList<Float> lng = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            List list = session1.createQuery("FROM ShopConnect").list();
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                ShopConnect cur = (ShopConnect) iterator.next();
                number.add(cur.getNumber_of_shop());
                lat.add(cur.getLat());
                lng.add(cur.getLng());
                name.add(cur.getName_of_shop());
            }
            session.setAttribute("numberOfShop",number);
            session.setAttribute("lat",lat);
            session.setAttribute("lng",lng);
            session.setAttribute("name",name);
            session.setAttribute("amountOfShops",number.size());
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            assert session1 != null;
            session1.close();
        }*/

        String l=returnCookieLang(session,request);
        response.sendRedirect("/resources/JSP/order.jsp?lang="+l);
    }
}
