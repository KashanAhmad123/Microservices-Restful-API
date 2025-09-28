package controller;

import java.util.List;

import Exceptions.DepartmentNotMaintained;
import Exceptions.WrongDepartmentID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import entity.department;
import respository.DepartmentRepository;
import service.DepartmentService;

@RestController
@RequestMapping("/api/office")
public class departmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
@Autowired
private DepartmentService departmentService;
	
	@PostMapping("/department")
	public department saveDepartment(@RequestBody department Department) {
		return departmentService.saveDepartment(Department);
}
	@GetMapping("/department")
	public List<department> fetchDepartment(){
		return departmentService.fetchDepartment();
	}

	@PutMapping("/department/{id}")
	public department updateById(@PathVariable("id") long departmentId,@RequestBody department Department ) {
		return departmentService.updateById(departmentId,Department);
	}

	@GetMapping("/{id}")
	public department getDepartmentById(long departmentId) throws DepartmentNotMaintained {
		return departmentService.fetchdepbyId(departmentId);
	}

	@DeleteMapping
	public boolean deleteDepartmentByID(long departmentId) throws WrongDepartmentID {
		departmentService.deletedepbyId(departmentId);

		return departmentRepository.isContain(departmentId);
	}
	
}