package cn.wormholestack.mse.facadeImpl.validator;

import cn.wormholestack.mse.common.exception.ValidateException;
import org.apache.commons.lang3.StringUtils;

/**
 * @description： BaseValidator
 * @Author MRyan
 * @Date 2021/11/14 11:04
 * @Version 1.0
 */
public class BaseValidator {

    /**
     * 参数不为空
     *
     * @param value
     * @throws ValidateException
     */
    protected void dtoNotNullValidate(Object value) throws ValidateException {
        if (value == null) {
            throw new ValidateException("参数不应为空!");
        }
    }

    /**
     * 属性对象不为空
     *
     * @param value
     * @throws ValidateException
     */
    protected void notNullValidate(String field, Object value) throws ValidateException {
        if (value == null) {
            throw new ValidateException(String.format("属性对象{}不应为空!", field));
        }
    }


    /**
     * 字段不为空
     *
     * @param field 在消息模板中显示的字段
     * @param value 待校验的值
     * @return
     */
    protected void notEmptyValidate(String field, String value) throws ValidateException {
        if (StringUtils.isBlank(value)) {
            throw new ValidateException(String.format("字段{}不应为空!", field));
        }
    }

}
