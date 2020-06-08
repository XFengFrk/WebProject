package org.ep2.hrmsdt.controller;


import org.ep2.hrmsdt.entity.Post;
import org.ep2.hrmsdt.service.PostService;
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
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @GetMapping("/all")
    public Map<String, Object> getPosts() {
        return ResponseJsonBuilder.success(100, "get post list successful!", postService.list());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPostById(@PathVariable("id") int id) {
        Post post = postService.getById(id);
        if (post != null) {
            return ResponseJsonBuilder.success(100, "get post successful!", post);
        } else {
            return ResponseJsonBuilder.error(200, "get post failed!");
        }
    }

    @PostMapping()
    public Map<String, Object> insertPost(@RequestBody Post post) {
        boolean res = postService.save(post);
        if (res) {
            return ResponseJsonBuilder.success(100, "insert post successful!", true);
        } else {
            return ResponseJsonBuilder.error(201, "insert post failed!");
        }
    }

    @PutMapping()
    public Map<String, Object> updatePostById(@RequestBody Post post) {
        boolean res = postService.updateById(post);
        if (res) {
            return ResponseJsonBuilder.success(100, "update post successful!", true);
        } else {
            return ResponseJsonBuilder.error(202, "update post failed!");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deletePostById(@PathVariable("id") int id) {
        boolean res = postService.removeById(id);
        if (res) {
            return ResponseJsonBuilder.success(100, "delete post successful!", true);
        } else {
            return ResponseJsonBuilder.error(203, "delete post failed!");
        }
    }
}