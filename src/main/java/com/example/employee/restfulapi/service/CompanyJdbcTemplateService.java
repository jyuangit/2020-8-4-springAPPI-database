package com.example.employee.restfulapi.service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanyJdbcTemplateService  {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List queryList(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from company");
        return list;
    }
//    public List selectById(){
//        String sql="";
//        List<Map<String, Object>> list = jdbcTemplate.;
//        return list;
//    }





}
