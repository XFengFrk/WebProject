package org.ep2.hrmsdt.controller;


import org.ep2.hrmsdt.entity.Employee;
import org.ep2.hrmsdt.service.EmployeeService;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nepsyn
 * @since 2020-06-07
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/all")
    public Map<String, Object> getEmployees() {
        return ResponseJsonBuilder.success(100, "get employee list successful!", employeeService.list());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getById(id);
        if (employee != null) {
            return ResponseJsonBuilder.success(100, "get employee successful!", employee);
        } else {
            return ResponseJsonBuilder.error(200, "get employee failed!");
        }
    }

    @PostMapping()
    public Map<String, Object> insertEmployee(@RequestBody Employee employee) {
        boolean res = employeeService.save(employee);
        if (res) {
            return ResponseJsonBuilder.success(100, "insert employee successful!", true);
        } else {
            return ResponseJsonBuilder.error(201, "insert employee failed!");
        }
    }

    @PutMapping()
    public Map<String, Object> updateEmployeeById(@RequestBody Employee employee) {
        boolean res = employeeService.updateById(employee);
        if (res) {
            return ResponseJsonBuilder.success(100, "update employee successful!", true);
        } else {
            return ResponseJsonBuilder.error(202, "update employee failed!");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteEmployeeById(@PathVariable("id") int id) {
        boolean res = employeeService.removeById(id);
        if (res) {
            return ResponseJsonBuilder.success(100, "delete employee successful!", true);
        } else {
            return ResponseJsonBuilder.error(203, "delete employee failed!");
        }
    }
}