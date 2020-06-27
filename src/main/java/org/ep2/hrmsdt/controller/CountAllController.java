package org.ep2.hrmsdt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.ep2.hrmsdt.entity.Employee;
import org.ep2.hrmsdt.entity.Title;
import org.ep2.hrmsdt.service.EmployeeService;
import org.ep2.hrmsdt.service.TitleService;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Doble
 * @since 2020-06-08
 */
@RestController
@RequestMapping("/count/all")


public class CountAllController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private TitleService titleService;

    public static String toPercent(float test) {
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format(test);
    }

    /*******************按职称统计所有员工情况**************/
    @GetMapping("/title")
    public Map<String, Object> countEmpAllByTitle() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("N_EMP_ID", 0);
        List<Employee> employees = employeeService.list(queryWrapper);
        List<Integer> T_ID = new ArrayList<>();
        List<String> T_N = new ArrayList<>();

        for (Employee test : employees) {
            T_ID.add(test.getTitleId());
        }

        for (Integer integer : T_ID) {
            Title test = titleService.getById(integer);
            T_N.add(test.getName());
        }

        Map<String, Integer> map1 = new HashMap<>();
        for (String string : T_N) {
            if (map1.containsKey(string)) {
                map1.put(string, map1.get(string) + 1);
            } else {
                map1.put(string, 1);
            }
        }

        List<Map<String,Object>> map = new ArrayList<>();

        for (String key : map1.keySet()) {
            Map<String, Object> map2 = new HashMap<>();
            float ratio = (float) map1.get(key) / T_ID.size();
            String percent = toPercent(ratio);
            map2.put("titleName", key);
            map2.put("num", map1.get(key));
            map2.put("ratio", percent);
            map.add(map2);
        }

        if (map.size() != 0) {
            return ResponseJsonBuilder.success(100, "get employee successfully", map);
        } else {
            return ResponseJsonBuilder.error(201, "get employee failed!");
        }
    }

    /*******************按性别统计所有员工情况**************/
    @GetMapping("/gender")
    public Map<String, Object> countEmpAllByGender() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("N_EMP_ID", 0);
        List<Employee> employees = employeeService.list(queryWrapper);
        List<String> genders = new ArrayList<>();

        for (Employee test : employees) {
            if(test.getGender() == 1) {
                genders.add("男");
            }else{
                genders.add("女");
            }

        }

        Map<String, Integer> map1 = new HashMap<>();
        for (String string : genders) {
            if (map1.containsKey(string)) {
                map1.put(string, map1.get(string) + 1);
            } else {
                map1.put(string, 1);
            }
        }

        List<Map<String,Object>> map = new ArrayList<>();

        for (String key : map1.keySet()) {
            Map<String, Object> map2 = new HashMap<>();
            float ratio = (float) map1.get(key) / genders.size();
            String percent = toPercent(ratio);
            map2.put("gender", key);
            map2.put("num", map1.get(key));
            map2.put("ratio", percent);
            map.add(map2);
        }

        if (map.size() != 0) {
            return ResponseJsonBuilder.success(100, "get employee successfully", map);
        } else {
            return ResponseJsonBuilder.error(201, "get employee failed!");
        }
    }

    /*******************按学历统计所有员工情况**************/
    @GetMapping("/level")
    public Map<String, Object> countEmpAllByLevel() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("N_EMP_ID", 0);
        List<Employee> employees = employeeService.list(queryWrapper);
        List<String> levels = new ArrayList<>();

        for (Employee test : employees) {
            if(test.getEducationLevel() == 5) {
                levels.add("高中");
            }else if (test.getEducationLevel() == 6){
                levels.add("专科");
            }else if (test.getEducationLevel() == 7){
                levels.add("本科");
            }else if (test.getEducationLevel() == 8) {
                levels.add("硕士");
            }else {
                levels.add("博士");
            }

        }

        Map<String, Integer> map1 = new HashMap<>();
        for (String string : levels) {
            if (map1.containsKey(string)) {
                map1.put(string, map1.get(string) + 1);
            } else {
                map1.put(string, 1);
            }
        }

        List<Map<String,Object>> map = new ArrayList<>();

        for (String key : map1.keySet()) {
            Map<String, Object> map2 = new HashMap<>();
            float ratio = (float) map1.get(key) / levels.size();
            String percent = toPercent(ratio);
            map2.put("level", key);
            map2.put("num", map1.get(key));
            map2.put("ratio", percent);
            map.add(map2);
        }

        if (map.size() != 0) {
            return ResponseJsonBuilder.success(100, "get employee successfully", map);
        } else {
            return ResponseJsonBuilder.error(201, "get employee failed!");
        }
    }

    /*******************按年龄统计所有员工情况**************/
    @GetMapping("/age")
    public Map<String, Object> countEmpAllByAge() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("N_EMP_ID", 0);
        List<Employee> employees = employeeService.list(queryWrapper);
        List<Integer> ages = new ArrayList<>();
        List<String> years = new ArrayList<>();

        for (Employee test : employees) {
            LocalDate birth = test.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate today = LocalDate.now();
            long duration = ChronoUnit.YEARS.between(birth,today);
            ages.add((int)duration);
        }

        for (int year : ages){
            if(year< 20){
                years.add("20岁以下");
            }else if(year <= 30){
                years.add("20-30岁");
            }else if(year <= 40){
                years.add("30-40岁");
            }else if(year <= 50){
                years.add("40-50岁");
            }else{
                years.add("50岁以上");
            }
        }

        Map<String, Integer> map1 = new HashMap<>();
        for (String string : years) {
            if (map1.containsKey(string)) {
                map1.put(string, map1.get(string) + 1);
            } else {
                map1.put(string, 1);
            }
        }

        List<Map<String,Object>> map = new ArrayList<>();

        for (String key : map1.keySet()) {
            Map<String, Object> map2 = new HashMap<>();
            float ratio = (float) map1.get(key) / ages.size();
            String percent = toPercent(ratio);
            map2.put("age", key);
            map2.put("num", map1.get(key));
            map2.put("ratio", percent);
            map.add(map2);
        }

        if (map.size() != 0) {
            return ResponseJsonBuilder.success(100, "get employee successfully", map);
        } else {
            return ResponseJsonBuilder.error(201, "get employee failed!");
        }
    }
}
