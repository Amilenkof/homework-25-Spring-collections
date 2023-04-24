package hw25.controller;

import hw25.Employee;
import hw25.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastname) {
        return employeeService.addEmployee(new Employee(firstName, lastname));
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastname) {
        return employeeService.findEmployee(firstName, lastname);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }


}

