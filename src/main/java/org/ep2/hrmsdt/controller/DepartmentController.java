package org.ep2.hrmsdt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.ep2.hrmsdt.entity.Department;
import org.ep2.hrmsdt.entity.Employee;
import org.ep2.hrmsdt.service.DepartmentService;
import org.ep2.hrmsdt.service.EmployeeService;
import org.ep2.hrmsdt.util.MoveToEntity;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nepsyn
 * @since 2020-06-07
 */
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/all")
    public Map<String, Object> getDepartments() {
        return ResponseJsonBuilder.success(100, "get department list successful!", departmentService.list());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getDepartmentById(@PathVariable("id") int id) {
        Department department = departmentService.getById(id);
        if (department != null) {
            return ResponseJsonBuilder.success(100, "get department successful!", department);
        } else {
            return ResponseJsonBuilder.error(200, "get department failed!");
        }
    }

    @GetMapping("/{id}/sub")
    public Map<String, Object> getSubDepartmentById(@PathVariable("id") int id) {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("N_PARENT_ID", id);
        List<Department> departments = departmentService.list(queryWrapper);

        return ResponseJsonBuilder.success(100, "get sub-departments successful!", departments);
    }

    @GetMapping("/removable")
    public Map<String, Object> getRemovableDepartmentIdList() {
        List<Integer> referredTitleIds = employeeService.list().stream().map(Employee::getDepartmentId).distinct().collect(Collectors.toList());
        List<Integer> removableIds = departmentService.list(new QueryWrapper<Department>().notIn("N_DEPT_ID", referredTitleIds)).stream().map(Department::getId).collect(Collectors.toList());

        return ResponseJsonBuilder.success(100, "get removable department id list successful!", removableIds);
    }

    @PostMapping
    public Map<String, Object> insertDepartment(@RequestBody Department department) {
        boolean res = departmentService.save(department);
        if (res) {
            return ResponseJsonBuilder.success(100, "insert department successful!", true);
        } else {
            return ResponseJsonBuilder.error(201, "insert department failed!");
        }
    }

    @PostMapping("/move")
    public Map<String, Object> moveDepartments(@RequestBody MoveToEntity moveObj) {
        if (moveObj.getFrom().contains(moveObj.getTo())) {
            return ResponseJsonBuilder.error(211, "move departments failed! the moving departments contain the target department");
        }

        UpdateWrapper<Department> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("N_DEPT_ID", moveObj.getFrom());
        updateWrapper.set("N_PARENT_ID", moveObj.getTo());
        departmentService.update(updateWrapper);

        return ResponseJsonBuilder.success(100, "move departments successful!", moveObj.getTo());
    }

    @PutMapping
    public Map<String, Object> updateDepartmentById(@RequestBody Department department) {
        boolean res = departmentService.updateById(department);
        if (res) {
            return ResponseJsonBuilder.success(100, "update department successful!", true);
        } else {
            return ResponseJsonBuilder.error(202, "update department failed!");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteDepartmentById(@PathVariable("id") int id) {
        UpdateWrapper<Department> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("N_PARENT_ID", id);
        updateWrapper.set("N_PARENT_ID", null);
        departmentService.update(updateWrapper);

        try {
            boolean res = departmentService.removeById(id);
            if (res) {
                return ResponseJsonBuilder.success(100, "delete department successful!", true);
            } else {
                return ResponseJsonBuilder.error(203, "delete department failed!");
            }
        } catch (Exception e) {
            return ResponseJsonBuilder.error(204, "delete department failed! caused by an unvalidated foreign key constraint");
        }
    }

    @DeleteMapping("/batch")
    public Map<String, Object> deleteDepartmentsByIds(@RequestBody List<Integer> ids) {
        int count = 0;

        for (int id: ids) {
            try {
                if (departmentService.removeById(id)) count++;
            } catch (Exception e) {
                return ResponseJsonBuilder.error(204, "delete departments failed! caused by an unvalidated foreign key constraint");
            }
        }
        return ResponseJsonBuilder.success(100, "delete departments successful!", count);
    }

    @DeleteMapping("/{id}/all")
    public Map<String, Object> deleteAllDepartmentsOfId(@PathVariable("id") int id) {
        Stack<Integer> deletingDepartmentIds = new Stack<>();
        Stack<Integer> departmentStack = new Stack<>();

        departmentStack.push(id);
        while (!departmentStack.isEmpty()) {
            Integer parentId = departmentStack.pop();
            deletingDepartmentIds.push(parentId);

            QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("N_PARENT_ID", parentId);
            List<Department> subDepartments = departmentService.list(queryWrapper);

            for (Department department: subDepartments) {
                departmentStack.push(department.getId());
            }
        }

        int departmentCount = deletingDepartmentIds.size();
        try {
            while (!deletingDepartmentIds.isEmpty()) {
                departmentService.removeById(deletingDepartmentIds.pop());
            }
        } catch (Exception e) {
            return ResponseJsonBuilder.error(204, "delete department and sub-departments failed! caused by an unvalidated foreign key constraint");
        }


        return ResponseJsonBuilder.success(100, "delete department and sub-departments successful!", departmentCount);
    }
}