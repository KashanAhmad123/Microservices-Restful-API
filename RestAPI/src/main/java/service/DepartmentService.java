package service;

import java.util.List;

import Exceptions.DepartmentNotMaintained;
import Exceptions.WrongDepartmentID;
import entity.department;

public interface DepartmentService {

	public department saveDepartment(department department);

	public List<department> fetchDepartment();

	public department fetchdepbyId(long departmentId) throws DepartmentNotMaintained;

	public void deletedepbyId(long departmentId) throws WrongDepartmentID;

	public department updateById(long departmentId, department department);

}
