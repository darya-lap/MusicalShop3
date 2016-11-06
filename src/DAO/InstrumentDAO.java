package DAO;

import ConnectToDB.InstrumentBean;
import DB.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDAO {

    public InstrumentBean getInstrumentById(Integer instrument_id) throws SQLException {
        Session session = null;
        List instrumentBean = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from InstrumentBean where id = :instrument_id");
            query.setParameter("instrument_id", instrument_id);
            instrumentBean = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (InstrumentBean) instrumentBean.get(0);
    }

    public List getAllInstruments() throws SQLException {
        Session session = null;
        List instruments = new ArrayList<InstrumentBean>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            instruments = session.createQuery("FROM InstrumentBean").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return instruments;
    }
}