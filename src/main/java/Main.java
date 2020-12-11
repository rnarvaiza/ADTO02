
import statements.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //InnerJoin.psij();
/*        long sal_min = 20000;
        long sal_max = 30000;

        try {
            ParameterFunction.setSalario_maximo(sal_max);
            ParameterFunction.setSalario_minimo(sal_min);
            ParameterFunction.rangoSalario();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

/*
        try{
            CalledProcedure.setComision_minimo(15);
            CalledProcedure.setComision_maximo(30);
            CalledProcedure.rangoComision();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
*/

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        long sal_min, sal_max, com_min, com_max;

        while (continuar) {
            System.out.println("1- Mostrar info de los empleados junto a su nombre de departamento. Se ordena por nombre de departamento");
            System.out.println("2- Llamar a la función almacenada que devuelve cuantos empleados están dentro del rango salarial que a continuación definirás.");
            System.out.println("3- Llamar al procedimiento almacenado que devuelve cuantos empleados están dentro del rango de comisión que a continuación definirás.");
            System.out.println("4- Salir");
            System.out.println("Introduce una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    InnerJoin.psij();
                    break;
                case 2:
                    System.out.println("Introduzca el salario mínimo por favor:");
                    sal_min=scanner.nextLong();
                    System.out.println("Introduzca el salario máximo por favor:");
                    sal_max=scanner.nextLong();
                    System.out.println("\n Trabajadores dentro del rango salarial definido: ");
                    try {
                        ParameterFunction.setSalario_maximo(sal_max);
                        ParameterFunction.setSalario_minimo(sal_min);
                        ParameterFunction.rangoSalario();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Introduzca la comisión mínima por favor:");
                    com_min=scanner.nextLong();
                    System.out.println("Introduzca la comisión máxima por favor:");
                    com_max=scanner.nextLong();
                    System.out.println("\n Trabajadores dentro de las comisiones definidas : ");
                    try{
                        CalledProcedure.setComision_minimo(com_min);
                        CalledProcedure.setComision_maximo(com_max);
                        CalledProcedure.rangoComision();
                    } catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Introduce una opción correcta (1-4)");
            }
        }

    }
}
