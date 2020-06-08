package org.ep2.hrmsdt.service.impl;

import org.ep2.hrmsdt.entity.User;
import org.ep2.hrmsdt.mapper.UserMapper;
import org.ep2.hrmsdt.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
