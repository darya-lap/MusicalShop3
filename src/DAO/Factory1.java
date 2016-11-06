package DAO;

public class Factory1 {

    private static ShopDAO shopDAO = null;
    private static InstrumentDAO instrumentDAO = null;
    private static OrderDAO orderDAO = null;
    private static Factory1 instance = null;

    public static synchronized Factory1 getInstance(){
        if (instance == null){
            instance = new Factory1();
        }
        return instance;
    }

    public ShopDAO getShopDAO(){
        if (shopDAO == null){
            shopDAO = new ShopDAO();
        }
        return shopDAO;
    }

    public OrderDAO getOrderDAO(){
        if (orderDAO == null){
            orderDAO = new OrderDAO();
        }
        return orderDAO;
    }

    public InstrumentDAO getInstrumentDAO(){
        if (instrumentDAO == null){
            instrumentDAO = new InstrumentDAO();
        }
        return instrumentDAO;
    }

}
