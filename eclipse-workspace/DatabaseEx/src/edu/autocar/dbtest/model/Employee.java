package edu.autocar.dbtest.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor




public class Employee {
	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate,
			String jobId, double salary, double commissionPct, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}

	private int 	employeeId;
	private String 	firstName;
	private String	lastName;
	private String	email;
	private String	phoneNumber;
	private Date	hireDate;
	private String	jobId;
	private double	salary;
	private double 	commissionPct;
	private int		managerId;
	private int		departmentId;
	
	public static class Builder {
		private int 		employeeId;
		private String 	firstName;
		private String		lastName;
		private String		email;
		private String		phoneNumber;
		private Date		hireDate;
		private String		jobId;
		private double		salary;
		private double 	commissionPct;
		private int			managerId;
		private int			departmentId;
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}
		public void setJobId(String jobId) {
			this.jobId = jobId;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public void setCommissionPct(double commissionPct) {
			this.commissionPct = commissionPct;
		}
		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}
		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}
		
		public Employee create() {
			return new Employee(int employeeId, firstName,    
					lastName, email, phoneNumber, hireDate,
					jobId, salary, commissionPct, managerId, departmentId);
		}

		
		
	}

}
