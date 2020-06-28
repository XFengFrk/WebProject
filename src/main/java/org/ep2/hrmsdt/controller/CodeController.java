package org.ep2.hrmsdt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.ep2.hrmsdt.entity.Code;
import org.ep2.hrmsdt.service.CodeService;
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
@RequestMapping("/api/code")
public class CodeController {
    @Resource
    private CodeService codeService;

    @GetMapping("/all")
    public Map<String, Object> getCodes() {
        return ResponseJsonBuilder.success(100, "get code list successful!", codeService.list());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getCodeById(@PathVariable("id") int id) {
        Code code = codeService.getById(id);
        if (code != null) {
            return ResponseJsonBuilder.success(100, "get code successful!", code);
        } else {
            return ResponseJsonBuilder.error(200, "get code failed!");
        }
    }

    @GetMapping("/label/{label}")
    public Map<String, Object> getCodeByLabel(@PathVariable("label") String label) {
        QueryWrapper<Code> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("VC_CODE_LABEL", label);
        List<Code> codes = codeService.list(queryWrapper);

        return ResponseJsonBuilder.success(100, "get code list successful!", codes);
    }

    @PostMapping
    public Map<String, Object> insertCode(@RequestBody Code code) {
        QueryWrapper<Code> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("VC_CODE_LABEL", code.getLabel());
        queryWrapper.eq("VC_CODE_VALUE", code.getValue());
        Code code_existing = codeService.getOne(queryWrapper);
        if (code_existing != null) {
            return ResponseJsonBuilder.error(204, "insert code failed! the same record is already existing");
        }


        boolean res = codeService.save(code);
        if (res) {
            Code code_new = codeService.getOne(queryWrapper);
            return ResponseJsonBuilder.success(100, "insert code successful!", code_new.getId());
        } else {
            return ResponseJsonBuilder.error(201, "insert code failed!");
        }
    }

    @PutMapping
    public Map<String, Object> updateCodeById(@RequestBody Code code) {
        boolean res = codeService.updateById(code);
        if (res) {
            return ResponseJsonBuilder.success(100, "update code successful!", true);
        } else {
            return ResponseJsonBuilder.error(202, "update code failed!");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteCodeById(@PathVariable("id") int id) {
        boolean res = codeService.removeById(id);
        if (res) {
            return ResponseJsonBuilder.success(100, "delete code successful!", true);
        } else {
            return ResponseJsonBuilder.error(203, "delete code failed!");
        }
    }

    @DeleteMapping("/batch")
    public Map<String, Object> deleteCodesByIds(@RequestBody List<Integer> ids) {
        int count = 0;

        for (int id: ids) {
            if (codeService.removeById(id)) count++;
        }

        return ResponseJsonBuilder.success(100, "delete codes successful!", count);
    }
}