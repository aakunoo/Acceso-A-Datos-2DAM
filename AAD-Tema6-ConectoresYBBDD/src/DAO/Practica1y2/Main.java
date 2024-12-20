package DAO.Practica1y2;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- Menú de Gestión de Empleados ---");
                System.out.println("1. Agregar un empleado");
                System.out.println("2. Buscar empleado por ID");
                System.out.println("3. Listar todos los empleados");
                System.out.println("4. Actualizar un empleado");
                System.out.println("5. Eliminar un empleado");
                System.out.println("6. Salir");
                System.out.println("7. Ver empleados con pedidos");
                System.out.println("8. Ver pedidos de un empleado");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar el buffer

                switch (opcion) {
                    case 1:
                        // Agregar un empleado
                        System.out.print("Ingrese el ID del empleado: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese el nombre: ");
                        String name = sc.nextLine();
                        System.out.print("Ingrese el apellido: ");
                        String lastName = sc.nextLine();
                        System.out.print("Ingrese el correo electrónico: ");
                        String email = sc.nextLine();
                        System.out.print("Ingrese el teléfono: ");
                        String phone = sc.nextLine();
                        System.out.print("Ingrese la fecha de contratación (yyyy-MM-dd): ");
                        String dateInput = sc.nextLine();
                        Date hireDate = Date.valueOf(dateInput);
                        System.out.print("Ingrese el puesto: ");
                        String jobTitle = sc.nextLine();
                        
                        Employee newEmployee = new Employee(id, name, lastName, email, phone, hireDate, jobTitle);
                        employeeDAO.addEmployee(newEmployee);
                        break;

                    case 2:
                        // Buscar empleado por ID
                        System.out.print("Ingrese el ID del empleado a buscar: ");
                        int searchId = sc.nextInt();
                        Employee foundEmployee = employeeDAO.getEmployeeById(searchId);
                        if (foundEmployee != null) {
                            System.out.println("\nEmpleado encontrado: " + foundEmployee.getName() + " " +
                                    foundEmployee.getLastName() + ", Email: " + foundEmployee.getEmail());
                        } else {
                            System.out.println("\nEmpleado no encontrado.");
                        }
                        break;

                    case 3:
                        // Listar todos los empleados
                        List<Employee> employees = employeeDAO.getAllEmployees();
                        System.out.println("\nLista de empleados:");
                        employees.forEach(e -> System.out.println(e.getEmployeeId() + " | " + e.getName() + " " + e.getLastName() + " (" + e.getEmail() + ")"));
                        break;

                    case 4:
                        // Actualizar un empleado
                        System.out.print("Ingrese el ID del empleado a actualizar: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        Employee employeeToUpdate = employeeDAO.getEmployeeById(updateId);
                        if (employeeToUpdate != null) {
                            System.out.print("Ingrese el nuevo nombre (actual: " + employeeToUpdate.getName() + "): ");
                            employeeToUpdate.setName(sc.nextLine());
                            System.out.print("Ingrese el nuevo puesto (actual: " + employeeToUpdate.getJobTitle() + "): ");
                            employeeToUpdate.setJobTitle(sc.nextLine());
                            employeeDAO.updateEmployee(employeeToUpdate);
                            System.out.println("Empleado actualizado exitosamente.");
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                        break;

                    case 5:
                        // Eliminar un empleado
                        System.out.print("Ingrese el ID del empleado a eliminar: ");
                        int deleteId = sc.nextInt();
                        employeeDAO.deleteEmployee(deleteId);
                        System.out.println("Empleado eliminado exitosamente.");
                        break;

                    case 6:
                        // Salir
                        System.out.println("Saliendo del programa...");
                        break;
                        
                        
                        // Implementaciones segundo ejercicio.
                    case 7:
                        // Ver empleados con pedidos
                        List<Employee> employeesWithOrders = employeeDAO.getEmployeesWithOrders();
                        if (employeesWithOrders.isEmpty()) {
                            System.out.println("No hay empleados con pedidos.");
                        } else {
                            employeesWithOrders.forEach(e -> System.out.println("ID: " + e.getEmployeeId() +
                                    ", Nombre: " + e.getName() + " " + e.getLastName()));
                        }
                        break;

                    case 8:
                        // Ver pedidos de un empleado
                        System.out.print("Ingrese el ID del empleado: ");
                        int empId = sc.nextInt();
                        employeeDAO.getOrdersByEmployeeId(empId);
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 6);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
