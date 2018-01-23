package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girla=new Girl();
        girla.setCupsize("A");
        girla.setAge(18);
        girlRepository.save(girla);

        Girl girlb=new Girl();
        girlb.setCupsize("B");
        girlb.setAge(18);
        girlRepository.save(girlb);
    }

    public void getage(Integer id) throws Exception {
        Girl girl =girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){
            //你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 &&age<16){
            //你在上初中吧
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
    //通过ID查询女生信息
    //@param id
    //@return
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
