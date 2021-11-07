package cn.wormholestack.mse.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description： MseTestApplicationTests
 * @Author MRyan
 * @Date 2021/11/7 17:41
 * @Version 1.0
 */
@SpringBootTest
public class MseTestApplicationTests {

    public Logger logger = LoggerFactory.getLogger(MseTestApplicationTests.class);

    @Test
    public void contextLoads() {
        logger.info("This is a test case!");
    }

}
