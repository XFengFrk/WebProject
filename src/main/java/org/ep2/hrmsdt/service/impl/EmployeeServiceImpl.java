package org.ep2.hrmsdt.service.impl;

import org.ep2.hrmsdt.entity.Employee;
import org.ep2.hrmsdt.mapper.EmployeeMapper;
import org.ep2.hrmsdt.service.EmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
