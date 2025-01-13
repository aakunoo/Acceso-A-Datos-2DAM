// default package
// Generated 13 ene 2025, 12:30:21 by Hibernate Tools 6.5.1.Final

import java.math.BigInteger;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
public class Orders implements java.io.Serializable {

	private BigInteger orderId;
	private Employees employees;
	private Customers customers;
	private String status;
	private Date orderDate;
	private Set orderItemses = new HashSet(0);

	public Orders() {
	}

	public Orders(BigInteger orderId, Customers customers, String status, Date orderDate) {
		this.orderId = orderId;
		this.customers = customers;
		this.status = status;
		this.orderDate = orderDate;
	}

	public Orders(BigInteger orderId, Employees employees, Customers customers, String status, Date orderDate,
			Set orderItemses) {
		this.orderId = orderId;
		this.employees = employees;
		this.customers = customers;
		this.status = status;
		this.orderDate = orderDate;
		this.orderItemses = orderItemses;
	}

	public BigInteger getOrderId() {
		return this.orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set getOrderItemses() {
		return this.orderItemses;
	}

	public void setOrderItemses(Set orderItemses) {
		this.orderItemses = orderItemses;
	}

}
