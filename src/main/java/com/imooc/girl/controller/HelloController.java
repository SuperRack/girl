package com.imooc.girl.controller;

import com.imooc.girl.properties.Girlproperties;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Autowired
    private Girlproperties girlproperties;

   // @RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){
        return "id: "+myid;
      // return girlproperties.getCupsize();

    }
}
