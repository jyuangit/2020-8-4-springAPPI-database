package com.example.employee.restfulapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.service.ICompanyService;
import com.example.employee.restfulapi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    //在此处完成Company API
    @Autowired
    ICompanyService companyService;
    @Autowired
    IEmployeeService employeeService;


    @GetMapping("")
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(companyService.list(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getone(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/emploees")
    public ResponseEntity getEmployeeByCompanyId(@PathVariable Long id) {
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        wrapper.eq("company_id",id);

        return new ResponseEntity<>(employeeService.list(wrapper), HttpStatus.OK);
    }
    @GetMapping("/page/{page}/pagesize/{pagesize}")
    public ResponseEntity pageList(@PathVariable Long page,@PathVariable Long pagesize ) {
        QueryWrapper<Company> wrapper=new QueryWrapper<>();
        Page page1=new Page();
        page1.setSize(pagesize);
        page1.setCurrent(page);
        companyService.page(page1,wrapper);
        return new ResponseEntity<>(companyService.page(page1,wrapper), HttpStatus.OK);
    }
    @PostMapping("")
    ResponseEntity add(@RequestBody Company company){

        return new ResponseEntity(companyService.save(company),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable Long id,@RequestBody Company  company){
        if(company.getId()==id && id.equals(company.getId())){
            return new ResponseEntity(companyService.saveOrUpdate(company),HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity("两次输入的id不一样请重新输入",HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity del(@PathVariable Long id){
        return new ResponseEntity(companyService.removeById(id),HttpStatus.NO_CONTENT);
    }



}
