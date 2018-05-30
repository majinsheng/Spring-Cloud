package org.service.repository;

import java.util.List;

import org.service.model.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public List<Employee> findByOrganizationId(String organizationId, PageRequest pageRequest);
}
