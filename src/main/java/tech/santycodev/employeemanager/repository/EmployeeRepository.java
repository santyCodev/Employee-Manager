package tech.santycodev.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.santycodev.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
