package statements;

/**
 * @author Rafa Narvaiza
 * AD TO 02
 *
 * EmployeesAndDepartments is designed to send a prepared statement with the department ID and show the department name
 * and all the info about its employees.
 */
import constants.ConstantsDB;
import constants.Statements;
import dbConnector.DBConnect;
import model.Closer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesAndDepartments {

    private static String DEPARTAMENTO;

    public static void employees(){
        Connection oConn = null;
        ResultSet rs=null;
        PreparedStatement pstmt = null;
        try{
            oConn=DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                pstmt = oConn.prepareStatement(Statements.EMPLOYEES_FROM_DEPARTMENT);
                pstmt.setString(1, getDEPARTAMENTO());
                pstmt.getResultSet();
                rs=pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println(
                            rs.getString("ID") + "\t\t"+
                                    rs.getString("APELLIDOS") + "\t\t"+
                                    rs.getString("FECHA_ALTA")+ "\t\t"+
                                    rs.getString("OFICIO")+ "\t\t"+
                                    rs.getString("SALARIO")+ "\t\t"+
                                    rs.getString("COMISION")+ "\t\t"+
                                    rs.getString("NOMBRE"));
                }
            } catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }finally {
                Closer.closingStatementAndResultSet(pstmt, rs);
            }
        }
    }

    public static String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public static void setDEPARTAMENTO(String DEPARTAMENTO) {
        EmployeesAndDepartments.DEPARTAMENTO = DEPARTAMENTO;
    }
}
