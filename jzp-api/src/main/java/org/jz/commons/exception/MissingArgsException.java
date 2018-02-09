package org.jz.commons.exception;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */
public class MissingArgsException extends Throwable {

    private String message;

    @Override
    public String getMessage() {
        return "Missing arguments";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MissingArgsException() {
    }

    public MissingArgsException(String message, String message1) {
        this.message = message1;
    }
}
