package test;

import edu.autocar.dbtest.model.Employee;

public class EmplyeeBuilderTest {

	public static void main(String[] args) {
		Employee emp = Employee.builder()
								.employeeId(10000)
								.lastName("Gildong")
								.firstName("Hong")
								.email("hong@naver.com")
								.build();
		
		System.out.println(emp);
	}

}
