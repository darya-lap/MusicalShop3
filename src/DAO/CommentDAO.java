package DAO;

import ConnectToDB.Comment;
import DB.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    public void setComment(Comment comment) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllComments() throws SQLException {
        Session session = null;
        List comments = new ArrayList<Comment>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            comments = session.createQuery("FROM Comment order by date desc").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return comments;
    }
}