package DAO;

import ConnectToDB.InstrumentBean;
import DB.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentDAO {

    public InstrumentBean getInstrumentById(Integer instrument_id) throws SQLException {
        Session session = null;
        InstrumentBean instrumentBean = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            instrumentBean = session.load(InstrumentBean.class, instrument_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return instrumentBean;
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