package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Employee;
import ua.lviv.iot.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService extends AbstractService<Employee, Integer> {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  protected JpaRepository<Employee, Integer> getRepository() {
    return employeeRepository;
  }

}