package businessLogic;

import dataAccess.Derby_Factory_DAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.*;
import javax.servlet.ServletContextListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    Derby_Factory_DAO dao = new Derby_Factory_DAO();

    @Override
    public void contextInitialized(ServletContextEvent event) { }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        dao.shutdown();
    }
}
