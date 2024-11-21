package pers.jhshop.common.exception;

import lombok.Data;

/**
 * 统一业务异常处理类
 * @author ChenJiahao(五条)
 * @date 2024/11/21 22:16:32
 */
@Data
public class ServiceException extends RuntimeException {

    private String code;
    private String msg;

    public ServiceException() {
        super();
    }

    public ServiceException(String msg) {
        super(msg);
        this.code = "FAIL";
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
