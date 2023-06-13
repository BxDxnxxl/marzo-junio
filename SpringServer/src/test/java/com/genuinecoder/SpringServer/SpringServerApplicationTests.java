package com.genuinecoder.SpringServer;

import com.genuinecoder.SpringServer.model.employee.Employee;
import com.genuinecoder.SpringServer.model.employee.EmployeeDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {
	@Autowired
	private EmployeeDao employeeDao;
	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("bruce wayne");
		employee.setBranch("bat calzoncillos");
		employee.setLocation("batcueva");
		employeeDao.save(employee);
	}
	void getAllEmployeesAndDeleteThem(){
		List<Employee> employees = employeeDao.getAllEmployees();
		System.out.println(employees);
		for(Employee employee: employees){
			employeeDao.delete(employee.getId());
		}
	}

}
