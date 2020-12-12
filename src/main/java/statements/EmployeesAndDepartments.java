package statements;

import constants.ConstantsDB;
import constants.Statements;
import dbConnector.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesAndDepartments {

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
                pstmt.setString(1, "MARKETING");
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
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) {
                    } // ignore
                    rs = null;
                }
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (SQLException sqlEx) {
                    } // ignore
                    pstmt = null;
                }
            }
        }


    }
}
