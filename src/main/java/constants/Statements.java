package constants;

/**
 * @author Rafa Narvaiza
 * AD TO 02
 *
 * Statements save all the statements as a constant string to avoid modification by others.
 */

public class Statements {


    public static final String INNER_JOIN_STMT = "SELECT * FROM VISTA_INNERJOIN;";
    public static final String PROCEDURE = "CALL rango_comision(?,?,?)";
    public static final String FUNCTION = "SELECT cantidad_trabajadores_rango_salario(?,?) AS 'rango_salarios'";
    public static final String EMPLOYEES_FROM_DEPARTMENT = "SELECT e.ID, e.APELLIDOS, e.SALARIO, e.FECHA_ALTA, e.OFICIO, e.SALARIO, e.COMISION, d.NOMBRE FROM EMPLEADOS e INNER JOIN DEPARTAMENTOS d ON d.ID=e.ID_DEPARTAMENTO WHERE d.NOMBRE=?";
    public static final String ECONOMIC_SUMMARY_STATEMENT = "SELECT COUNT(e.APELLIDOS) AS 'CANTIDAD EMPLEADOS', SUM(e.SALARIO) AS 'PARTIDA PRESUPUESTARIA', d.NOMBRE AS 'NOMBRE DEPARTAMENTO' FROM DEPARTAMENTOS d INNER JOIN EMPLEADOS e ON e.ID_DEPARTAMENTO=d.ID GROUP BY d.ID;";
    public static final String UPDATE_SALARY_FROM_DEPARTMENT = "UPDATE EMPLEADOS SET SALARIO=SALARIO*? WHERE ID_DEPARTAMENTO=?";
    public static final String SHOW_SALARY_EMPLOYEES_AND_DEPARTMENT = "SELECT e.SALARIO, e.APELLIDOS, d.NOMBRE AS 'NOMBRE DEPARTAMENTO' FROM DEPARTAMENTOS d INNER JOIN EMPLEADOS e ON e.ID_DEPARTAMENTO=d.ID WHERE d.NOMBRE=? GROUP BY e.ID;";
}
