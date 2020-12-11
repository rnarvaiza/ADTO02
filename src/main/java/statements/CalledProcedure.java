package statements;

import constants.ConstantsDB;
import constants.Statements;
import db.DBConnect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CalledProcedure {

    private static long comision_minimo;
    private static long comision_maximo;

    public static void rangoComision() throws SQLException{
        Connection oConn = null;

        try{
            oConn= DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);
            CallableStatement cs = oConn.prepareCall(Statements.PROCEDURE);
            cs.setLong(1, getComision_minimo());
            cs.setLong(2, getComision_maximo());
            cs.registerOutParameter(3, Types.INTEGER);
            cs.executeUpdate();
            int cantidadEmpleados = cs.getInt(3);
            System.out.println(cantidadEmpleados);
            cs.close();
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
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
