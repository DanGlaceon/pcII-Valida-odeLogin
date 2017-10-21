package Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
    
    public Connection getMysqlConnection() throws Exception {
    String stringConnection = "jdbc:mysql://localhost/sistema";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(stringConnection,"root","");
    return conn;
    
    }
    
}
