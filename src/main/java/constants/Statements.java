package constants;

import statements.ParameterFunction;

public class Statements {


    public static final String INNER_JOIN_STMT = "SELECT * FROM VISTA_INNERJOIN;";
    public static final String PROCEDURE = "CALL rango_comision(?,?,?)";
    public static final String FUNCTION = "SELECT cantidad_trabajadores_rango_salario(?,?) AS 'rango_salarios'";
    public static final String EMPLOYEES_FROM_DEPARTMENT = "SELECT e.ID, e.APELLIDOS, e.SALARIO, e.FECHA_ALTA, e.OFICIO, e.SALARIO, e.COMISION, d.NOMBRE FROM EMPLEADOS e INNER JOIN DEPARTAMENTOS d ON d.ID=e.ID_DEPARTAMENTO WHERE d.NOMBRE=?";


}
