package statements;

import constants.ConstantsDB;
import constants.Statements;
import dbConnector.DBConnect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CalledProcedure {

    private static long comision_minimo;
    private static long comision_maximo;

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
                cs.setLong(1, getComision_minimo());
                cs.setLong(2, getComision_maximo());
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


    public static long getComision_minimo() {
        return comision_minimo;
    }

    public static void setComision_minimo(long comision_minimo) {
        CalledProcedure.comision_minimo = comision_minimo;
    }

    public static long getComision_maximo() {
        return comision_maximo;
    }

    public static void setComision_maximo(long comision_maximo) {
        CalledProcedure.comision_maximo = comision_maximo;
    }
}
