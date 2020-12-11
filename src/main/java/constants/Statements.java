package constants;

import statements.ParameterFunction;

public class Statements extends ParameterFunction {


    public static final String INNER_JOIN_STMT = "SELECT e.APELLIDOS, e.OFICIO, e.FECHA_ALTA, e.SALARIO, e.COMISION, e.ID_DEPARTAMENTO, d.NOMBRE, d.LOCALIZACION, e.ID from DEPARTAMENTOS d inner join EMPLEADOS e on d.ID=e.ID_DEPARTAMENTO order by d.NOMBRE";
    public static final String PROCEDURE = "CALL rango_comision(?,?,?)";
    public static final String FUNCTION = "SELECT cantidad_trabajadores_rango_salario(?,?) AS 'rango_salarios'";

}
