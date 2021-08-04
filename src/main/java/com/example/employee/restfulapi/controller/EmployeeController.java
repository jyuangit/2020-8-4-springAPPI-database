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
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //在此处完成Employee API


    @Autowired
    ICompanyService companyService;
    @Autowired
    IEmployeeService employeeService;



    @GetMapping("")
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(employeeService.list(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getone(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/male")
    public ResponseEntity getEmployeeByCompanyId() {
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        wrapper.eq("gender","male");

        return new ResponseEntity<>(employeeService.list(wrapper), HttpStatus.OK);
    }
    @GetMapping("/page/{page}/pagesize/{pagesize}")
    public ResponseEntity pageList(@PathVariable Long page,@PathVariable Long pagesize ) {
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        Page page1=new Page();
        page1.setSize(pagesize);
        page1.setCurrent(page);
        employeeService.page(page1,wrapper);
        return new ResponseEntity<>(employeeService.page(page1,wrapper), HttpStatus.OK);
    }
    @PostMapping("")
    ResponseEntity add(@RequestBody Employee employee){

        return new ResponseEntity(employeeService.saveOrUpdate(employee),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable Integer id,@RequestBody Employee  employee){
        if(employee.getId()==id && id.equals(employee.getId())){
            return new ResponseEntity(employeeService.saveOrUpdate(employee),HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity("两次输入的id不一样请重新输入",HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity del(@PathVariable Long id){
        return new ResponseEntity(employeeService.removeById(id),HttpStatus.NO_CONTENT);
    }

}
