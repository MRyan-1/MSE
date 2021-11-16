package cn.wormholestack.mse.common.exception;

/**
 * @description： MSEErrorFactory
 * @Author MRyan
 * @Date 2021/11/13 16:35
 * @Version 1.0
 */
public class MSEErrorFactory {

    /**
     * 获取MSEErrorFactory单例
     *
     * @return instance
     */
    public static MSEErrorFactory getInstance() {
        return MSEErrorFactoryHolder.INSTANCE;
    }


    private static final class MSEErrorFactoryHolder {
        /**
         * instance
         */
        private static final MSEErrorFactory INSTANCE = new MSEErrorFactory();
    }

}
