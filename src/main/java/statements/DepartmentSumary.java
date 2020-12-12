package statements;

/**
 * @author Rafa Narvaiza
 * AD TO 02
 *
 *DepartmentSummary is designed for calling an prepared statement which returns all the departments which its ammount of employees
 * and the total expenses of each department.
 */

import constants.ConstantsDB;
import constants.Statements;
import dbConnector.DBConnect;
import model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentSumary {

    public static void sumary(){

        Connection oConn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            oConn= DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                stmt = oConn.createStatement();
                rs = stmt.executeQuery(Statements.ECONOMIC_SUMMARY_STATEMENT);

                while (rs.next()) {
                    System.out.println(
                            rs.getString("CANTIDAD EMPLEADOS") + "\t\t"+
                                    rs.getString("PARTIDA PRESUPUESTARIA") + "\t\t"+
                                    rs.getString("NOMBRE DEPARTAMENTO"));

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
