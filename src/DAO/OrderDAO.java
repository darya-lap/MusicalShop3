package DAO;

import ConnectToDB.Order;
import DB.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

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
}