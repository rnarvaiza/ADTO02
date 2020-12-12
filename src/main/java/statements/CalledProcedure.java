package statements;

/**
 * @author Rafa Narvaiza
 * AD TO 02
 *
 * CalledProcedure is designed for call a procedure with two input parameters and one output parameter.
 *
 */

import constants.ConstantsDB;
import constants.Statements;
import dbConnector.DBConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CalledProcedure {

    private static long COMISION_MINIMA;
    private static long COMISION_MAXIMA;

    public static void rangoComision() throws SQLException{
        Connection oConn = null;
        CallableStatement cs = null;

        try{
            oConn= DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                cs = oConn.prepareCall(Statements.PROCEDURE);
                cs.setLong(1, getComisionMinima());
                cs.setLong(2, getComisionMaxima());
                cs.registerOutParameter(3, Types.INTEGER);
                cs.executeUpdate();
                int cantidadEmpleados = cs.getInt(3);
                System.out.println(cantidadEmpleados);

            } catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } finally {
                if ((cs != null)){
                    try{
                        cs.close();
                    }catch (SQLException sqle){
                        System.out.println("SQLException @ CallableStatement calling close" + sqle.getMessage());
                    }
                    cs = null;
                }
            }
        }

    }


    public static long getComisionMinima() {
        return COMISION_MINIMA;
    }

    public static void setComisionMinima(long comisionMinima) {
        CalledProcedure.COMISION_MINIMA = comisionMinima;
    }

    public static long getComisionMaxima() {
        return COMISION_MAXIMA;
    }

    public static void setComisionMaxima(long comisionMaxima) {
        CalledProcedure.COMISION_MAXIMA = comisionMaxima;
    }
}
