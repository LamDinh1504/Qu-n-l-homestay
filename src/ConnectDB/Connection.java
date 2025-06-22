
package ConnectDB;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {
    public static java.sql.Connection getOracleConnection() throws ClassNotFoundException,
            SQLException {

        //Host name
        String hostName = "localhost";
        //SID Oralce
        String sid = "orcls";
        //Username
        String userName = "QUANLYMONHOC";
        
        //Password
        String password = "Admin123";
        
     
        Class.forName("oracle.jdbc.driver.OracleDriver");

     
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" +sid;

        //Tạo đối tượng connection
        java.sql.Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        
        return conn;
    }
}
