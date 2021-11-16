package cn.wormholestack.mse.test.search;

import cn.wormholestack.mse.boot.MseBootApplication;
import cn.wormholestack.mse.facade.MSEService;
import cn.wormholestack.mse.facade.model.search.SearchReq;
import cn.wormholestack.mse.facade.model.search.SearchRes;
import cn.wormholestack.mse.facadeImpl.Interceptor.SearchInterceptor;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @description： MapstructTest
 * @Author MRyan
 * @Date 2021/11/13 23:06
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MseBootApplication.class})
public class SearchTest {

    private Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @Resource
    private MSEService mseService;

    @Resource
    SearchInterceptor searchInterceptor;

    @Test
    public void TEST_SEARCH() throws InterruptedException, BlockException {
        SearchReq searchReq = new SearchReq();
        searchReq.setQuestion("How is the MSE");
        searchReq.setType("WEB");
        SearchRes search = mseService.search(searchReq);
        logger.info(JSON.toJSONString(search));


    }
}
