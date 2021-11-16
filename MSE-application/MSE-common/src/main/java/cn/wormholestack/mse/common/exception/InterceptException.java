package cn.wormholestack.mse.common.exception;

/**
 * @description： ConverterException
 * @Author MRyan
 * @Date 2021/11/14 10:43
 * @Version 1.0
 */
public class InterceptException extends MSEException {

    public InterceptException() {
        super();
    }

    public InterceptException(final Throwable throwable) {
        super(throwable);
    }

    public InterceptException(final String detailMessage) {
        super(detailMessage);
    }

    public InterceptException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
    }

}
