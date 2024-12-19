package DAO.Practica1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
    	String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, JOB_TITLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employee.getEmployeeId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getLastName());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime())); // Convertir a java.sql.Date
            stmt.setString(7, employee.getJobTitle());
            stmt.executeUpdate();
            System.out.println("Empleado agregado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),rs.getString("LAST_NAME") , rs.getString("EMAIL"), rs.getString("PHONE"),rs.getDate("HIRE_DATE"), rs.getString("JOB_TITLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),rs.getString("LAST_NAME") , rs.getString("EMAIL"), rs.getString("PHONE"),rs.getDate("HIRE_DATE"), rs.getString("JOB_TITLE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ?, HIRE_DATE = ?, JOB_TITLE = ? WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setDate(5, employee.getHireDate());
            stmt.setString(6, employee.getJobTitle());
            stmt.setInt(7, employee.getEmployeeId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
