package controller;

import Exceptions.DepartmentNotMaintained;
import Exceptions.WrongDepartmentID;
import entity.department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;


@Controller
@RequestMapping("/department")
public class webDepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public String saveDepartment(@ModelAttribute department Department){
      departmentService.saveDepartment(Department);
      return "redirect/department";
    }

    @GetMapping
    public String fetchDepartment(Model model){
        model.addAttribute("departments",departmentService.fetchDepartment());
        model.addAttribute("product", new department());
        return "department";
    }

    @GetMapping("/edit/{id}")
    public String getProductByID(@PathVariable Long id, Model model) throws DepartmentNotMaintained {
        model.addAttribute("product", departmentService.fetchdepbyId(id));
        model.addAttribute("products", departmentService.fetchDepartment());
        return "products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute department Department) {
        departmentService.updateById(id,Department);
        return "redirect:/departments";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) throws WrongDepartmentID {
        departmentService.deletedepbyId(id);
        return "redirect:/departments";
    }
}
