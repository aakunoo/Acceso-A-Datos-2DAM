package DAO.Practica1;

import java.sql.Date;

public class Employee {
   
	private int employeeId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date hireDate;
    private String jobTitle;

    // Constructor vacío
    public Employee() {}

    // Constructor completo
    public Employee(int employeeId, String name, String lastName, String email, String phone, Date hireDate, String jobTitle) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.jobTitle = jobTitle;
    }

    // Getters y Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
    
    
}
