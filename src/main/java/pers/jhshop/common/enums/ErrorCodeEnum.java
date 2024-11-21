package pers.jhshop.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误枚举
 * @author ChenJiahao(五条)
 * @date 2024/11/21 22:14:59
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    /**
     * 系统类错误码
     */
    OK("OK", ""),
    FAIL("FAIL", "操作失败"),
    BIZ_FAIL("BIZ_FAIL", "业务处理失败"),
            ;

    private String code;
    private String msg;
}
