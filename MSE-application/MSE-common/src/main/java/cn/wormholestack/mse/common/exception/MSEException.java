package cn.wormholestack.mse.common.exception;

/**
 * @description： MSEException
 * @Author MRyan
 * @Date 2021/11/13 16:35
 * @Version 1.0
 */
public class MSEException extends Exception {

    private String detailMessage;

    public MSEException() {
        super();
    }

    public MSEException(final Throwable throwable) {
        super(throwable);
    }

    public MSEException(final String detailMessage) {
        super(detailMessage);
        this.detailMessage = detailMessage;
    }

    public MSEException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
        this.detailMessage = detailMessage;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}
