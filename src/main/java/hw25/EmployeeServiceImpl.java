package hw25;

import hw25.exceptions.EmployeeAlreadyAddedException;
import hw25.exceptions.EmployeeNotFoundException;
import hw25.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    int maxSize = 3;

    ArrayList<Employee> employees = new ArrayList<>(maxSize);

    @Override
    public Employee addEmployee(Employee employee) {


        if (employees.size() >= maxSize) {
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
        }

        for (Employee emp : employees) {
            if (employee.equals(emp))
                throw new EmployeeAlreadyAddedException("В коллекции уже есть такой сотрудник ");
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else throw new EmployeeNotFoundException("Удаление не возможно-сотрудник не найден");


    }

    @Override
    public Employee findEmployee(String firstname, String lastname) {
        for (Employee emp : employees) {
            if (emp.getFirstName().equalsIgnoreCase(firstname) & emp.getLastName().equalsIgnoreCase(lastname)) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");

    }
}
