package cn.wormholestack.mse.common.exception;

/**
 * @description： ConverterException
 * @Author MRyan
 * @Date 2021/11/14 10:43
 * @Version 1.0
 */
public class ConverterException extends MSEException {

    public ConverterException() {
        super();
    }

    public ConverterException(final Throwable throwable) {
        super(throwable);
    }

    public ConverterException(final String detailMessage) {
        super(detailMessage);
    }

    public ConverterException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
    }

}
