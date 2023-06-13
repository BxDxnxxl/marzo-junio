package com.genuinecoder.SpringServer.model.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Integer>{

}
