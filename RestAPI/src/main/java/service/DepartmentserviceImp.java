package service;

import java.util.List;
import java.util.Objects;

import Exceptions.DepartmentNotMaintained;
import Exceptions.WrongDepartmentID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import entity.department;
import respository.DepartmentRepository;

@Service
public class DepartmentserviceImp implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	
	@Override
	public department saveDepartment(department department) {
		return departmentRepository.save(department);
	}


	@Override
	public List<department> fetchDepartment() {
		return departmentRepository.findAll();
	}


	@Cacheable(value = "id")
	@Override
	public department fetchdepbyId(long departmentId) throws DepartmentNotMaintained {
		if(departmentId == 0){
			throw new DepartmentNotMaintained("Wrong Details");
		}

		return departmentRepository.findById(departmentId).orElseThrow();
	}


	@Override
	public void deletedepbyId(long departmentId) throws WrongDepartmentID {
		if(departmentId>110 || departmentId<=0){
			throw new WrongDepartmentID("Department with ID doesn't exist in the database");
		}
		departmentRepository.deleteById(departmentId);
	}


	@CacheEvict(value = "department", key = "#id")
	@Override
	public department updateById(long departmentId,department department) {
	department dbm= departmentRepository.findById(departmentId).get();
	if(Objects.nonNull(department.getDepartmentName()) && !" ".equalsIgnoreCase(department.getDepartmentName())) {
		dbm.setDepartmentName(department.getDepartmentName());
	}
	
	if(Objects.nonNull(department.getDepartmentAdd()) && !" ".equalsIgnoreCase(department.getDepartmentAdd())) {
		dbm.setDepartmentAdd(department.getDepartmentAdd());
	}
	
	if(Objects.nonNull(department.getDeparmentCode()) && !" ".equalsIgnoreCase(department.getDeparmentCode())) {
		dbm.setDeparmentCode(department.getDeparmentCode());
	}
	
	return departmentRepository.save(dbm);
		
	}

}
