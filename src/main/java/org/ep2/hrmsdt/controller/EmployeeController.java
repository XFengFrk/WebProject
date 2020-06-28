package org.ep2.hrmsdt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.ep2.hrmsdt.entity.Employee;
import org.ep2.hrmsdt.service.EmployeeService;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
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
@RequestMapping("/api/employee")
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

    // 搜索员工信息
    @PostMapping("/search")
    public Map<String, Object> searchEmployee(@RequestBody Employee employee) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();

        // 构造一个and条件连接查询
        queryWrapper.and(wrapper -> {
            // 对于int类型用eq,对于String类型用like
            wrapper.like(employee.getName() != null,"VC_EMP_NAME", employee.getName());
            wrapper.like(employee.getCode() != null, "VC_EMP_CODE", employee.getCode());
            wrapper.eq(employee.getDepartmentId() != null, "N_DEPT_ID", employee.getDepartmentId());
            wrapper.eq(employee.getGender() != null, "N_GENDER", employee.getGender());
            if (employee.getBirthday() != null) wrapper.apply(String.format("DATEDIFF(D_BIRTHDAY,'%s')=0", new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirthday())));
            wrapper.eq(employee.getEducationLevel() != null, "N_EDU_LEVEL", employee.getEducationLevel());
            wrapper.eq(employee.getTitleId() != null, "N_TITLE_ID", employee.getTitleId());
            wrapper.eq(employee.getPostId() != null, "N_POST_ID", employee.getPostId());
            wrapper.eq(employee.getHealth() != null, "N_HEALTH", employee.getHealth());
            wrapper.like(employee.getIdCardCode() != null, "VC_IDCARD_CODE", employee.getIdCardCode());
            wrapper.eq(employee.getNation() != null, "N_NATION", employee.getNation());
            wrapper.eq(employee.getParty() != null, "N_PARTY", employee.getParty());
            wrapper.eq(employee.getStatus() != null, "N_STATUS", employee.getStatus());
            wrapper.like(employee.getNativePlace() != null, "VC_NATIVE_PLACE", employee.getNativePlace());
            wrapper.eq(employee.getRegType() != null, "N_REG_TYPE", employee.getRegType());
        });

        List<Employee> resEmployees = employeeService.list(queryWrapper);

        if (resEmployees.size() > 0) {
            return ResponseJsonBuilder.success(100, "get employee successful!", resEmployees);
        } else {
            return ResponseJsonBuilder.error(200, "get employee failed! no matching employee founded under search condition");
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

    // 删除多个员工信息
    @DeleteMapping("/batch")
    public Map<String, Object> deleteEmployeesByIds(@RequestBody List<Integer> ids) {
        int count = 0;

        for (int id: ids) {
            if (employeeService.removeById(id)) count++;
        }

        return ResponseJsonBuilder.success(100, "delete employees successful!", count);
    }
}