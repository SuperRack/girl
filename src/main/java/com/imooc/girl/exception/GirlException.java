package com.imooc.girl.exception;

import com.imooc.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer Code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.Code=resultEnum.getCode();
    }

    public Integer getCode() {
        return Code;
    }
    public void setCode(Integer code){
        this.Code=code;
    }
}
