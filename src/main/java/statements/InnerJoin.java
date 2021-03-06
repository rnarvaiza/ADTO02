package statements;


/**
 * @author Rafa Narvaiza
 * AD TO 02
 *
 * "psij" Executes a query containing the innerjoined statement.
 */

import constants.*;
import dbConnector.*;
import model.*;
import java.sql.*;

public class InnerJoin {

    public static void psij(){

        Connection oConn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            oConn=DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                stmt = oConn.createStatement();
                rs = stmt.executeQuery(Statements.INNER_JOIN_STMT);

                while (rs.next()) {
                    System.out.println(
                            rs.getString("ID") + "\t\t"+
                            rs.getString("NOMBRE") + "\t\t"+
                            rs.getString("APELLIDOS") + "\t\t"+
                            rs.getString("OFICIO") + "\t\t"+
                            rs.getString("FECHA_ALTA")+ "\t\t"+
                            rs.getString("SALARIO")+ "\t\t"+
                            rs.getString("COMISION")+ "\t\t"+
                            rs.getString("ID_DEPARTAMENTO")+ "\t\t"+
                            rs.getString("LOCALIZACION"));

                }
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } finally {
                Closer.closingStatementAndResultSet(stmt, rs);
            }
        }

    }

}
