package com.example.employee.restfulapi.mapper;

import com.example.employee.restfulapi.entity.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jyuan
 * @since 2021-08-04
 */
public interface CompanyMapper extends BaseMapper<Company> {
    Boolean updateCompanyById(Long id);

}
