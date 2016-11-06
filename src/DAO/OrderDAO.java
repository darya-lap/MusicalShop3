package DAO;

import ConnectToDB.Order;
import DB.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void setOrder(Order order) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getHistoryOfUser(String user1) throws SQLException {
        Session session = null;
        List order = new ArrayList<Order>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Order where user = :user1");
            query.setParameter("user1", user1);
            order = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return order;
    }
}