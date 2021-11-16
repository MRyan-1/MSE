package cn.wormholestack.mse.common.exception;

/**
 * @description： ValidateException
 * @Author MRyan
 * @Date 2021/11/14 10:44
 * @Version 1.0
 */
public class ValidateException extends MSEException {


    public ValidateException() {
        super();
    }

    public ValidateException(final Throwable throwable) {
        super(throwable);
    }

    public ValidateException(final String detailMessage) {
        super(detailMessage);
    }

    public ValidateException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
    }
}
