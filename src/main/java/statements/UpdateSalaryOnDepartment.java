package statements;

import constants.ConstantsDB;
import constants.Statements;
import dbConnector.DBConnect;
import model.Closer;

import java.sql.*;

import static constants.Statements.UPDATE_SALARY_FROM_DEPARTMENT;

public class UpdateSalaryOnDepartment {

    private static double porcentaje_incremento;
    private static int id_departamento;
    private static String DEPARTAMENTO;

    public static void manageUpdate() {
        Connection oConn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            oConn = DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                pstmt = oConn.prepareStatement(UPDATE_SALARY_FROM_DEPARTMENT);
                pstmt.setDouble(1, getPorcentaje_incremento());
                pstmt.setInt(2, getId_departamento());
                pstmt.executeUpdate();

            }catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } finally {
                Closer.closingStatementAndResultSet(pstmt, rs);
            }
        }
    }

    public static double getPorcentaje_incremento() {
        return porcentaje_incremento;
    }

    public static void setPorcentaje_incremento(double porcentaje_incremento) {
        UpdateSalaryOnDepartment.porcentaje_incremento = porcentaje_incremento;
    }

    public static int getId_departamento() {
        return id_departamento;
    }

    public static void setId_departamento(int id_departamento) {
        UpdateSalaryOnDepartment.id_departamento = id_departamento;
    }

    public static void showSalaryOnEveryWorkerOfDepartment(){
        Connection oConn = null;
        ResultSet rs=null;
        PreparedStatement pstmt = null;
        try{
            oConn=DBConnect.getDBConnection(ConstantsDB.URL, ConstantsDB.USER, ConstantsDB.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                pstmt = oConn.prepareStatement(Statements.SHOW_SALARY_EMPLOYEES_AND_DEPARTMENT);
                pstmt.setString(1, getDEPARTAMENTO());
                pstmt.getResultSet();
                rs=pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println(
                            rs.getString("SALARIO") + "\t\t"+
                                    rs.getString("APELLIDOS") + "\t\t"+
                                    rs.getString("NOMBRE DEPARTAMENTO"));
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
        UpdateSalaryOnDepartment.DEPARTAMENTO = DEPARTAMENTO;
    }
}
