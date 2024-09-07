package service;

import java.util.List;

import entity.department;

public interface DepartmentService {

	public department saveDepartment(department department);

	public List<department> fetchDepartment();

	public department fetchdepbyId(long departmentId);

	public void deletedepbyId(long departmentId);

	public department updateById(long departmentId,department department);

}
