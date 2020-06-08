package org.ep2.hrmsdt.service.impl;

import org.ep2.hrmsdt.entity.Post;
import org.ep2.hrmsdt.mapper.PostMapper;
import org.ep2.hrmsdt.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nepsyn
 * @since 2020-06-07
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
