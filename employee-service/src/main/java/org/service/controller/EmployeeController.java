package org.service.controller;

import java.util.List;
import java.util.Optional;

import org.service.model.Employee;
import org.service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/")
	public Employee add(@RequestBody Employee employee) {
		logger.info("Employee insert: {}", employee);
		return repository.insert(employee);
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> findById(@PathVariable("id") String id) {
		logger.info("Employee find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/organization/{organizationId}/page/{start}/{end}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") String organizationId, @PathVariable("start") int start, @PathVariable("end") int end) {
		logger.info("Employee find: departmentId={}", organizationId);
		return repository.findByOrganizationId(organizationId,PageRequest.of(start, end));
	}
}
