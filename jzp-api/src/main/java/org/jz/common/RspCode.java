package org.jz.common;

/**
 * @author Hongyi Zheng
 * @date 2018/3/8
 */
public enum  RspCode{

    /** response -- success*/
    SUCCESS("200","success"),

    /** response -- system error*/
    SYS("404","system error"),

    /** response -- wrong params*/
    INVALID_PARAMS("401","wrong parameters");

    private String code;
    private String message;

    RspCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code(){
        return code;
    }

    public String message(){
        return message;
    }


}
