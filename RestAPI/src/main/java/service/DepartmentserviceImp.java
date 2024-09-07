package service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.department;
import respository.DepartmentRepository;

@Service
public class DepartmentserviceImp implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public department saveDepartment(department department) {
		return departmentRepository.save(department);
	}


	@Override
	public List<department> fetchDepartment() {
		return departmentRepository.findAll();
	}


	@Override
	public department fetchdepbyId(long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}


	@Override
	public void deletedepbyId(long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}


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
