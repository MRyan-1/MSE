package cn.wormholestack.mse.common.exception;

/**
 * @description： MSEError
 * @Author MRyan
 * @Date 2021/11/13 16:35
 * @Version 1.0
 */
public class MSEException extends Exception {

    public MSEException() {
        super();
    }

    public MSEException(final Throwable throwable) {
        super(throwable);
    }

    public MSEException(final String detailMessage) {
        super(detailMessage);
    }

    public MSEException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
    }

}
