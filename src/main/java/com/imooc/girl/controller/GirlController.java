package com.imooc.girl.controller;

import com.imooc.girl.Utils.ResultUtil;
import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
/*
 查询女生列表
 */

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        System.out.println("girlList");
        return girlRepository.findAll();
    }

    /*
    添加一个女生
     */
    @RequestMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupsize(girl.getCupsize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @RequestMapping(value = "/girl01/{id}")
    public Girl girlFindone(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    //更新
    @RequestMapping(value = "/girl02/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupsize") String cupsize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupsize(cupsize);
        girl.setId(id);
        return girlRepository.save(girl);
    }
    //删除
    @RequestMapping(value = "/girl03/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }
    //通过年龄来查询女生
    @RequestMapping(value = "/girl/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @RequestMapping(value = "/girl/two")
    public void girlTwo(){

        girlService.insertTwo();
    }


    @GetMapping(value = "/getage/{id}")
    public void getage(@PathVariable("id") Integer id) throws Exception {

        girlService.getage(id);
    }




}