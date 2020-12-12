package model;

/**
 * @author Rafa Narvaiza
 * AD TO 02
 *
 * Menu class display throw shell a command menu to manage all the clases.
 * We tried to manage all the exceptions on the inputs, gramatically and coherently.
 */
import statements.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void showMenu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Scanner scannerForDouble = new Scanner(System.in);
        Scanner scannerForLong = new Scanner(System.in);
        boolean continuar = true;
        int opcion, numero;
        long com_min=1;
        long com_max=0;
        long sal_min =1;
        long sal_max = 0;
        double porcentaje_incremento;

        while (continuar) {
            System.out.println();
            System.out.println("1- Mostrar info de los empleados junto a su nombre de departamento. Se ordena por nombre de departamento.");
            System.out.println("2- Llamar a la función almacenada que devuelve cuantos empleados están dentro del rango salarial que a continuación definirás.");
            System.out.println("3- Llamar al procedimiento almacenado que devuelve cuantos empleados están dentro del rango de comisión que a continuación definirás.");
            System.out.println("4- Muestra los empleados de un departamento.");
            System.out.println("5- Actualiza los salarios de un determinado departamento aplicando una porcentaje.");
            System.out.println("6- Muestra el número de empleados de cada departamento y la partida presupuestaria de cada departamento.");
            System.out.println("7- Salir.");
            System.out.println("Introduce una opción: ");
            try{
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        InnerJoin.psij();
                        break;
                    case 2:
                        try{
                            //Avoid to type on sal_max the lower one of the gap.
                            while(sal_max<sal_min){
                                System.out.println("Introduzca el salario mínimo por favor:");
                                sal_min=scannerForLong.nextLong();
                                System.out.println("Introduzca el salario máximo por favor:");
                                sal_max=scannerForLong.nextLong();
                                if (sal_max<sal_min){
                                    System.out.println("Por favor, introduzca el salario mínimo y máximo correctamente.");
                                }
                            }
                            System.out.println("\n Trabajadores dentro del rango salarial definido: ");
                            try {
                                ParameterFunction.setSalario_maximo(sal_max);
                                ParameterFunction.setSalario_minimo(sal_min);
                                ParameterFunction.rangoSalario();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            System.out.println();
                        } catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try{
                            //Avoid to type on the lower side of the gap the max value.
                            while(com_max<=com_min){
                                System.out.println("Introduzca la comisión mínima por favor:");
                                com_min=scannerForLong.nextLong();
                                System.out.println("Introduzca la comisión máxima por favor:");
                                com_max=scannerForLong.nextLong();
                                if (com_max<com_min){
                                    System.out.println("Por favor, introduzca las comisiones correctamente.");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\n Trabajadores dentro de las comisiones definidas : ");
                        CalledProcedure.setComisionMinima(com_min);
                        CalledProcedure.setComisionMaxima(com_max);
                        CalledProcedure.rangoComision();
                        System.out.println();
                        break;
                    case 4:
                        try{
                            System.out.println("Seleccione el número de departamento para mostrar sus empleados:");
                            System.out.println("#1 para Marketing");
                            System.out.println("#2 para RRHH");
                            System.out.println("#3 para Logística");
                            System.out.println("#4 para Calidad");
                            numero = scanner.nextInt();
                            if (numero == 1){
                                EmployeesAndDepartments.setDEPARTAMENTO("MARKETING");
                                EmployeesAndDepartments.employees();
                                System.out.println();
                            }
                            if (numero == 2){
                                EmployeesAndDepartments.setDEPARTAMENTO("RRHH");
                                EmployeesAndDepartments.employees();
                                System.out.println();
                            }
                            if (numero == 3){
                                EmployeesAndDepartments.setDEPARTAMENTO("LOGISTICA");
                                EmployeesAndDepartments.employees();
                                System.out.println();
                            }
                            if (numero == 4){
                                EmployeesAndDepartments.setDEPARTAMENTO("CALIDAD");

                                //LO TIENES REPETIDO *4, SACALO AFUERA
                                EmployeesAndDepartments.employees();
                                System.out.println();
                            }
                            System.out.println();
                        } catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        UpdateSalaryOnDepartment.showSalaryOnEveryWorkerOfDepartment();
                        try{
                            System.out.println();
                            System.out.println("A continuación vamos a actualizar el salario de todos los empleados de un departamento. ");
                            System.out.println("#1 para Marketing");
                            System.out.println("#2 para RRHH");
                            System.out.println("#3 para Logística");
                            System.out.println("#4 para Calidad");
                            numero = scanner.nextInt();
                            if (numero == 1){
                                UpdateSalaryOnDepartment.setId_departamento(numero);
                                UpdateSalaryOnDepartment.setDEPARTAMENTO("MARKETING");
                                System.out.println();
                            }
                            if (numero == 2){
                                UpdateSalaryOnDepartment.setId_departamento(numero);
                                UpdateSalaryOnDepartment.setDEPARTAMENTO("RRHH");
                                System.out.println();
                            }
                            if (numero == 3){
                                UpdateSalaryOnDepartment.setId_departamento(numero);
                                UpdateSalaryOnDepartment.setDEPARTAMENTO("LOGISTICA");
                                System.out.println();
                            }
                            if (numero == 4){
                                UpdateSalaryOnDepartment.setId_departamento(numero);
                                UpdateSalaryOnDepartment.setDEPARTAMENTO("CALIDAD");
                                System.out.println();
                            }
                        } catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        try{
                            System.out.println();
                            System.out.println("El salario de los trabajadores del departamento elegido, antes de actualizar es de:");
                            System.out.println();
                            UpdateSalaryOnDepartment.showSalaryOnEveryWorkerOfDepartment();
                        }catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println();
                        System.out.println("Y a continuación, elija el porcentaje(ej. 1.20 para incrementar un 20% el salario");
                        try{
                            porcentaje_incremento = scannerForDouble.nextDouble();
                            System.out.println();
                            UpdateSalaryOnDepartment.setPorcentaje_incremento(porcentaje_incremento);
                            UpdateSalaryOnDepartment.manageUpdate();
                        } catch (InputMismatchException e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println();
                        System.out.println("El salario de los trabajadores del departamento elegido, después de actualizar es de:");
                        System.out.println();
                        UpdateSalaryOnDepartment.showSalaryOnEveryWorkerOfDepartment();
                        break;
                    case 6:
                        DepartmentSumary.sumary();
                        System.out.println();
                        break;
                    case 7:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Introduce una opción correcta (1-7)");
                }
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
