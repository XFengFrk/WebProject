package org.ep2.hrmsdt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.ep2.hrmsdt.entity.User;
import org.ep2.hrmsdt.service.UserService;
import org.ep2.hrmsdt.util.ResponseJsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping()
    public Map<String, Object> getLoginStatus(HttpSession httpSession) {
        String username = (String) httpSession.getAttribute("username");

        if (username != null) {
            return ResponseJsonBuilder.success(100, "already logged in!", username);
        } else {
            return ResponseJsonBuilder.error(300, "not logged in!");
        }
    }

    @PostMapping("/login")
    public Map<String, Object> doLogin(@RequestBody User user, HttpSession httpSession) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("VC_USERNAME", user.getUsername());
        queryWrapper.eq("VC_PASSWORD", user.getPassword());

        int count = userService.count(queryWrapper);

        if (count > 0) {
            httpSession.setAttribute("username", user.getUsername());
            return ResponseJsonBuilder.success(100, "login successful!", user.getUsername());
        } else {
            return ResponseJsonBuilder.error(301, "login failed! wrong username or password");
        }
    }

    @PostMapping("/logout")
    public Map<String, Object> doLogout(HttpSession httpSession) {
        httpSession.removeAttribute("username");

        return ResponseJsonBuilder.success(100, "logout successful!", null);
    }

    @GetMapping("/all")
    public Map<String, Object> getUsers() {
        return ResponseJsonBuilder.success(100, "get user list successful!", userService.list());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getUserById(@PathVariable("id") int id) {
        User user = userService.getById(id);
        if (user != null) {
            return ResponseJsonBuilder.success(100, "get user successful!", user);
        } else {
            return ResponseJsonBuilder.error(200, "get user failed!");
        }
    }

    @PostMapping()
    public Map<String, Object> insertUser(@RequestBody User user) {
        boolean res = userService.save(user);
        if (res) {
            return ResponseJsonBuilder.success(100, "insert user successful!", true);
        } else {
            return ResponseJsonBuilder.error(201, "insert user failed!");
        }
    }

    @PutMapping()
    public Map<String, Object> updateUserById(@RequestBody User user) {
        boolean res = userService.updateById(user);
        if (res) {
            return ResponseJsonBuilder.success(100, "update user successful!", true);
        } else {
            return ResponseJsonBuilder.error(202, "update user failed!");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteUserById(@PathVariable("id") int id) {
        boolean res = userService.removeById(id);
        if (res) {
            return ResponseJsonBuilder.success(100, "delete user successful!", true);
        } else {
            return ResponseJsonBuilder.error(203, "delete user failed!");
        }
    }
}