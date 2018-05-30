package org.service.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Organization {
	
	@Id
	private String id;
	private String name;
	private String sequence;
	private String parentOrgId;
	
	@Transient
	private List<Employee> employees = new ArrayList<>();
	@Transient
	private List<Organization> subOrgs = new ArrayList<>();

	public Organization() {

	}
	
	public Organization(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public List<Organization> getSubOrgs() {
		return subOrgs;
	}

	public void setSubOrgs(List<Organization> subOrgs) {
		this.subOrgs = subOrgs;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + "]";
	}
}
