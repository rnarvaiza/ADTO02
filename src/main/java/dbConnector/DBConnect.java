package dbConnector;

import constants.ConstantsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    public static Connection getDBConnection(String url, String user, String password) throws SQLException, ClassNotFoundException {
        Connection oConn = null;
        Class.forName(ConstantsDB.DRIVER_NAME);
        oConn = DriverManager.getConnection(url,user,password);
        //System.out.println("¡Conexión a la base de datos realizada!");
        return oConn;
    }
}
