package org.service.client;

import java.util.List;

import org.service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

	@GetMapping("/organization/{organizationId}/page/{start}/{end}")
	List<Employee> findByOrganizationId(@PathVariable("organizationId") String organizationId, @PathVariable("start") int start, @PathVariable("end") int end);
	
}
