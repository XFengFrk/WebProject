package org.ep2.hrmsdt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.ep2.hrmsdt.entity.Employee;
import org.ep2.hrmsdt.entity.Title;
import org.ep2.hrmsdt.service.EmployeeService;
import org.ep2.hrmsdt.service.TitleService;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/title")
public class TitleController {
    @Resource
    private TitleService titleService;
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/all")
    public Map<String, Object> getTitles() {
        return ResponseJsonBuilder.success(100, "get title list successful!", titleService.list());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getTitleById(@PathVariable("id") int id) {
        Title title = titleService.getById(id);
        if (title != null) {
            return ResponseJsonBuilder.success(100, "get title successful!", title);
        } else {
            return ResponseJsonBuilder.error(200, "get title failed!");
        }
    }

    @GetMapping("/name/{name}")
    public Map<String, Object> getMostTitleByName(@PathVariable String name) {
        QueryWrapper<Title> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("VC_TITLE_NAME", name);
        List<Title> titleList = titleService.list(queryWrapper);

        if (titleList.size() > 0) {
            return ResponseJsonBuilder.success(100,"get title successful!", titleList);
        }
        else {
            return ResponseJsonBuilder.error(200, "get title failed!");
        }
    }

    @GetMapping("/removable")
    public  Map<String, Object> getRemovableTitleIdList() {
        List<Integer> referredTitleIds = employeeService.list().stream().map(Employee::getTitleId).distinct().collect(Collectors.toList());
        List<Integer> removableIds = titleService.list(new QueryWrapper<Title>().notIn("N_TITLE_ID", referredTitleIds)).stream().map(Title::getId).collect(Collectors.toList());

        return ResponseJsonBuilder.success(100, "get removable title id list successful!", removableIds);
    }

    @PostMapping()
    public Map<String, Object> insertTitle(@RequestBody Title title) {
        boolean res = titleService.save(title);
        if (res) {
            return ResponseJsonBuilder.success(100, "insert title successful!", true);
        } else {
            return ResponseJsonBuilder.error(201, "insert title failed!");
        }
    }

    @PutMapping()
    public Map<String, Object> updateTitleById(@RequestBody Title title) {
        boolean res = titleService.updateById(title);
        if (res) {
            return ResponseJsonBuilder.success(100, "update title successful!", true);
        } else {
            return ResponseJsonBuilder.error(202, "update title failed!");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteTitleById(@PathVariable("id") int id) {
        try {
            boolean res = titleService.removeById(id);

            if (res) {
                return ResponseJsonBuilder.success(100, "delete title successful!", true);
            } else {
                return ResponseJsonBuilder.error(203, "delete title failed!");
            }
        } catch (Exception e) {
            return ResponseJsonBuilder.error(204, "delete title failed! caused by an unvalidated foreign key constraint");
        }
    }

    @DeleteMapping("/batch")
    public Map<String, Object> deleteTitlesByIds(@RequestBody List<Integer> ids) {
        int count = 0;

        for (int id: ids) {
            try {
                if (titleService.removeById(id)) count++;
            } catch (Exception e) {
                return ResponseJsonBuilder.error(204, "delete titles failed! caused by an unvalidated foreign key constraint");
            }
        }
        return ResponseJsonBuilder.success(100, "delete titles successful!", count);
    }
}