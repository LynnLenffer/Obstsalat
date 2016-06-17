package dataAccess;

public abstract class DAO_Factory {

    // List of User_DAO types supported by the factory
    public static final int DERBY = 1;
    // There will be a method for each User_DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract User_DAO getUserDAO();
    //public abstract void shutdown();

    public static DAO_Factory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case DERBY:
                return new Derby_Factory_DAO();
            default:
                return null;
        }
    }

    public void shutdown() {}

}
