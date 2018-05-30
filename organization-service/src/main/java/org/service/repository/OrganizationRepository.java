package org.service.repository;

import java.util.List;

import org.service.model.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

	public List<Organization> findByParentOrgId(String parentOrgId);
}
