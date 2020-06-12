package org.ep2.hrmsdt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.ep2.hrmsdt.entity.Title;
import org.ep2.hrmsdt.service.TitleService;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @DeleteMapping("/batch")
    public Map<String, Object> deleteTitlesByIds(@RequestBody List<Integer> ids) {
        int count = 0;

        for (int id: ids) {
            if (titleService.removeById(id)) count++;
        }

        return ResponseJsonBuilder.success(100, "delete titles successful!", count);
    }
}