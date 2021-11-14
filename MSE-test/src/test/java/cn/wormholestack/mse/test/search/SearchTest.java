package cn.wormholestack.mse.test.search;

import cn.wormholestack.mse.boot.MseBootApplication;
import cn.wormholestack.mse.common.model.search.SearchReqVO;
import cn.wormholestack.mse.facade.MSEService;
import cn.wormholestack.mse.facade.model.search.SearchReq;
import cn.wormholestack.mse.facade.model.search.SearchRes;
import cn.wormholestack.mse.facadeimpl.converter.SearchConverter;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
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

    @Test
    public void TEST_SEARCH() {
        SearchReq searchReq = new SearchReq();
        searchReq.setQuestion("How is the MSE");
        searchReq.setType("web");
        SearchRes search = mseService.search(searchReq);
        logger.info(JSON.toJSONString(search));
    }
}
