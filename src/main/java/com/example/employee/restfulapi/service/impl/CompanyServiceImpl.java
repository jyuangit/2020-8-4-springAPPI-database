package com.example.employee.restfulapi.service.impl;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.mapper.CompanyMapper;
import com.example.employee.restfulapi.service.ICompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
