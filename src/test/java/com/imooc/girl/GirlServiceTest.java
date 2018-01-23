package com.imooc.girl;


import com.imooc.girl.domain.Girl;
import com.imooc.girl.service.GirlService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;
    @Test
    public void findOneTest(){
        Girl girl=girlService.findOne(16);
        Assert.assertEquals(new Integer(15),girl.getAge());
    }

}
