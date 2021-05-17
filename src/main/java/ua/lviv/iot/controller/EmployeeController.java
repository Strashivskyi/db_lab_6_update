package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Employee;
import ua.lviv.iot.dto.EmployeeDTO;
import ua.lviv.iot.service.EmployeeService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/employee")
@RestController
public class EmployeeController {
  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<EmployeeDTO>> getAll() {
    List<Employee> employees = employeeService.getAll();
    List<EmployeeDTO> employeeDtos = new ArrayList<>();
    for (Employee employee : employees) {
      EmployeeDTO employeeDto = new EmployeeDTO (
          employee.getId(),
          employee.getPhoneNumber(),
          employee.getEmail(),
          employee.getBirthday(),
          employee.getGender(),
          employee.getFirstName(),
          employee.getLastName(),
          employee.getCityId(),
          employee.getAmusementParkId(),
          employee.getPositionId()
      );
      employeeDtos.add(employeeDto);
    }
    return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<EmployeeDTO> getById(@PathVariable Integer id) {
    Employee employee = employeeService.getById(id);
    try {
      if (employeeService.getById(id) != null && employeeService.getById(id).getFirstName() != null) {
        EmployeeDTO employeeDto = new EmployeeDTO(
            employee.getId(),
            employee.getPhoneNumber(),
            employee.getEmail(),
            employee.getBirthday(),
            employee.getGender(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getCityId(),
            employee.getAmusementParkId(),
            employee.getPositionId()
        );
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<EmployeeDTO> create(@RequestBody Employee employee) {
    employeeService.create(employee);
    EmployeeDTO employeeDto = new EmployeeDTO(
        employee.getId(),
        employee.getPhoneNumber(),
        employee.getEmail(),
        employee.getBirthday(),
        employee.getGender(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getCityId(),
        employee.getAmusementParkId(),
        employee.getPositionId()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
  }
  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<EmployeeDTO> update(@PathVariable Integer id,
                                        @RequestBody Employee employee) {
    try {
      employee.setId(id);
      Employee oldEmployee = employeeService.getById(id);
      if (oldEmployee != null && oldEmployee.getFirstName() != null) {
        employeeService.update(id, employee);
        EmployeeDTO newEmployeeDto = new EmployeeDTO(
            employee.getId(),
            employee.getPhoneNumber(),
            employee.getEmail(),
            employee.getBirthday(),
            employee.getGender(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getCityId(),
            employee.getAmusementParkId(),
            employee.getPositionId()
        );
        return new ResponseEntity<>(newEmployeeDto, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    try {
      if (employeeService.getById(id) != null && employeeService.getById(id).getFirstName() != null) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}



