package org.ep2.hrmsdt.controller;


import org.ep2.hrmsdt.entity.Title;
import org.ep2.hrmsdt.service.TitleService;
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
@RequestMapping("/title")
public class TitleController {
    @Resource
    private TitleService titleService;

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
        boolean res = titleService.removeById(id);
        if (res) {
            return ResponseJsonBuilder.success(100, "delete title successful!", true);
        } else {
            return ResponseJsonBuilder.error(203, "delete title failed!");
        }
    }
}