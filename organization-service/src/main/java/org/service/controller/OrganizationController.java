package org.service.controller;

import java.util.Optional;

import org.service.client.EmployeeClient;
import org.service.model.Organization;
import org.service.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {
	private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	OrganizationRepository repository;
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		logger.info("Organization insert: {}", organization);
		return repository.insert(organization);
	}
	
	@GetMapping("/{id}")
	public Optional<Organization> findById(@PathVariable("id") String id) {
		logger.info("Organization find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/{id}/with-suborganizations")
	public Optional<Organization> findByIdWithSuborganizations(@PathVariable("id") String id) {
		logger.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		organization.ifPresent(d -> {
			d.setSubOrgs(repository.findByParentOrgId(d.getId()));
		});
		return organization;
	}
	
	@GetMapping("/{id}/with-employees/page/{start}/{end}")
	public Optional<Organization> findByIdWithEmployees(@PathVariable("id") String id, @PathVariable("start") int start, @PathVariable("end") int end) {
		logger.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		organization.ifPresent(d -> {
			d.setEmployees(employeeClient.findByOrganizationId(d.getId(),start, end));
		});
		return organization;
	}
}
