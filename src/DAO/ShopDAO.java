package DAO;

import ConnectToDB.Shop;
import DB.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

    public Shop getShopByNumber(Integer shop_number) throws SQLException {
        Session session = null;
        Shop shop = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            shop = session.load(Shop.class, shop_number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shop;
    }

    public List getAllShopsLat() throws SQLException {
        Session session = null;
        List shops = new ArrayList<Shop>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            shops = session.createQuery("select lat FROM Shop ").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shops;
    }

    public List getAllShopsLng() throws SQLException {
        Session session = null;
        List shops = new ArrayList<Shop>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            shops = session.createQuery("select lng FROM Shop ").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shops;
    }

    public List getAllShopsNames() throws SQLException {
        Session session = null;
        List shops = new ArrayList<Shop>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            shops = session.createQuery("select name_of_shop FROM Shop ").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shops;
    }

    public List getAllShopsNumbers() throws SQLException {
        Session session = null;
        List shops = new ArrayList<Shop>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            shops = session.createQuery("select number_of_shop FROM Shop ").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shops;
    }
}