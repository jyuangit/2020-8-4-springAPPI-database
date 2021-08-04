package com.example.employee.restfulapi.service.impl;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.mapper.EmployeeMapper;
import com.example.employee.restfulapi.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jyuan
 * @since 2021-08-04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
