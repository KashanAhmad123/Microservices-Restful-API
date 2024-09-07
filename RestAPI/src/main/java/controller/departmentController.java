package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.department;
import service.DepartmentService;

@RestController
public class departmentController {
	
	
@Autowired
private DepartmentService departmentService;
	
	@PostMapping("/department")
	public department saveDepartment(@RequestBody department Department) {
		return departmentService.saveDepartment(Department);
}
	@GetMapping("/deparment")
	public List<department> fetchDepartment(){
		return departmentService.fetchDepartment();
	}
	
	@GetMapping("/department/{id}")
	public department fetchdepbyId(@PathVariable("id") long departmentId) {
		return departmentService.fetchdepbyId(departmentId);
	}
	
	@DeleteMapping("/department/{id}")
	public String deletedeptbyId(@PathVariable("id") long departmentId) {
		departmentService.deletedepbyId(departmentId);
		return "Department Deleted";
	}
	
	@PutMapping("/department/{id}")
	public department updateById(@PathVariable("id") long departmentId, department Department ) {
		return departmentService.updateById(departmentId,Department);
	}
	
}