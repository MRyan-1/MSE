package cn.wormholestack.mse.common.exception;

/**
 * @description： ServiceException
 * @Author MRyan
 * @Date 2021/11/14 10:50
 * @Version 1.0
 */
public class ServiceException extends MSEException {

    public ServiceException() {
        super();
    }

    public ServiceException(final Throwable throwable) {
        super(throwable);
    }

    public ServiceException(final String detailMessage) {
        super(detailMessage);
    }

    public ServiceException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
    }

}
