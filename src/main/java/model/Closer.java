package model;

/**
 * @author Rafa Narvaiza
 * AD TO 02
 * This constructor is designed to close Statement and ResultSet constructors.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Closer {

    public static void closingStatementAndResultSet(Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) {
            } // ignore
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            } // ignore
            stmt = null;
        }
    }
}
