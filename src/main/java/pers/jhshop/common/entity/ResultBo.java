package pers.jhshop.common.entity;

import lombok.Data;
import pers.jhshop.common.enums.ErrorCodeEnum;

/**
 * 请求的返回指定的类型
 * @author ChenJiahao(五条)
 * @date 2024/11/21 22:08:20
 */
@Data
public class ResultBo<T> {

    /**
     * 说明请求是否成功
     */
    private Boolean result;

    /**
     * 请求状态码
     */
    private String code;
    /**
     * 附加的返回的说明信息
     */
    private String msg;
    /**
     * 请求返回的数据
     */
    private T data;

    /**
     * 空参构造
     */
    public ResultBo() {
        super();
    }

    /**
     * 请求成功的信息和数据两参数构造
     */
    public ResultBo(String msg, T data) {
        super();
        this.result = true;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无数据构造
     */
    public ResultBo(Boolean result, ErrorCodeEnum errorCode, String msg) {
        super();
        this.result = result;
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public ResultBo(Boolean result, String errorCode, String msg) {
        super();
        this.result = result;
        this.code = errorCode;
        this.msg = msg;
    }

    public ResultBo(Boolean result, ErrorCodeEnum errorCode) {
        super();
        this.result = result;
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    /**
     * 请求成功的单数据参数构造
     */
    public ResultBo(T data, ErrorCodeEnum errorCode) {
        super();
        this.result = true;
        this.code = errorCode.name();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    /**
     * 请求成功有数据
     */
    public static <T> ResultBo<T> success(T data) {
        return new ResultBo<T>(data, ErrorCodeEnum.OK);
    }

    /**
     * 请求成功无数据
     */
    public static <T> ResultBo<T> success() {
        return new ResultBo<T>(true, ErrorCodeEnum.OK);
    }

    /**
     * 请求失败有信息
     */
    public static <T> ResultBo<T> error(String msg) {
        return new ResultBo<T>(false, ErrorCodeEnum.BIZ_FAIL, msg);
    }

    public static <T> ResultBo<T> error(String code, String msg) {
        return new ResultBo<T>(false, code, msg);
    }

    /**
     * 请求失败默认信息
     */
    public static <T> ResultBo<T> error() {
        return new ResultBo<T>(false, ErrorCodeEnum.BIZ_FAIL);
    }

    public static <T> ResultBo<T> successOrError(Boolean flag) {
        return flag ? success() : error();
    }

    /**
     * 请求失败默认信息
     */
    public static <T> ResultBo<T> errorOther(ErrorCodeEnum errorCode) {
        return new ResultBo<T>(false, errorCode);
    }

    /**
     * 请求成功的单数据参数构造
     * ResultBo.
     * <p>Title: </p>
     * <p>Description: </p>
     *
     * @param date
     */
    public ResultBo(T date) {
        super();
        this.result = true;
        this.msg = "请求成功";
        this.data = date;
    }
}
