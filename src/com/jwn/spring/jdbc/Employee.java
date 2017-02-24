package com.jwn.spring.jdbc;

public class Employee
{
	private Integer id;
	private String lastName;
	private String email;
	
	private Integer deptId;
	
	private Department department;
	public void setDepartment(Department department)
	{
		this.department = department;
	}
	public Department getDepartment()
	{
		return department;
	}

	public void setDeptId(Integer deptId)
	{
		this.deptId = deptId;
	}
	public Integer getDeptId()
	{
		return deptId;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", deptId=" + deptId + ", department=" + department
				+ "]";
	}

	

}
