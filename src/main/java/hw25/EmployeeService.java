package hw25;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(String firstname, String lastName);

    Employee findEmployee(String firstname, String lastname);
}
