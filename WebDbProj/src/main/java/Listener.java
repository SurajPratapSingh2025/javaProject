

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener{

    
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Listener Start");
    	
    	InputStream resourceAsStream = sce.getServletContext().getResourceAsStream("/WEB-INF/config.properties");
    	Properties properties = new Properties();
    	try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	String username = properties.getProperty("db.user");
    	String password = properties.getProperty("db.pass");
    	String url = properties.getProperty("db.url");
    	String driver = properties.getProperty("db.driver");
    	
    	try {
			ConnectionFactory.init(driver,url,username,password);
			Connection connection = ConnectionFactory.getConnection();
			//i want to print connection on web
			sce.getServletContext().setAttribute("dbConnection", connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Listener End");
    }
    
    
	
}
