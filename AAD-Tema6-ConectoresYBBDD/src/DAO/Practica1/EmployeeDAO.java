package DAO.Practica1;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
