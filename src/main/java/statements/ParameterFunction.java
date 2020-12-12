package statements;
import constants.*;
import dbConnector.DBConnect;

import java.sql.*;

public class ParameterFunction {

    private static long salario_minimo;
    private static long salario_maximo;


    public static void rangoSalario() throws SQLException {
        Connection oConn = null;
        ResultSet rs = null;
        try {
            oConn=DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);
            PreparedStatement preparedStatement = oConn.prepareStatement(Statements.FUNCTION);
            preparedStatement.setLong(1, getSalario_minimo());
            preparedStatement.setLong(2, getSalario_maximo());
            preparedStatement.getResultSet();
            rs=preparedStatement.executeQuery();
            while
            (rs.next()){
                System.out.println(rs.getString("rango_salarios"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static long getSalario_minimo() {
        return salario_minimo;
    }

    public static void setSalario_minimo(long salario_minimo) {
        ParameterFunction.salario_minimo = salario_minimo;
    }

    public static long getSalario_maximo() {
        return salario_maximo;
    }

    public static void setSalario_maximo(long salario_maximo) {
        ParameterFunction.salario_maximo = salario_maximo;
    }
}
