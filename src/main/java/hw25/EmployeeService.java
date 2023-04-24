package hw25;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(String firstname, String lastName);

    Employee findEmployee(String firstname, String lastname);
     Collection<Employee> getAllEmployees ();

}
