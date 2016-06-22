package dataAccess;

public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();
    public abstract PostDAO getPostDAO();
    public abstract void shutdown();

    public static DAOFactory getDAOFactory(String factoryName) {

        if( factoryName.equals("MySQL") ) {
            return new MySQLDAOFactory();
        }
        else {
            return null;
        }

    }

}
