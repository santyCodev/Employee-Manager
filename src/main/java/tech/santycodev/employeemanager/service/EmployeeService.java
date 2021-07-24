package tech.santycodev.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.santycodev.employeemanager.exception.UserNotFoundException;
import tech.santycodev.employeemanager.model.Employee;
import tech.santycodev.employeemanager.repository.EmployeeRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee findEmployee(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(
                () -> new UserNotFoundException("User by id "+id+" was not found"));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
