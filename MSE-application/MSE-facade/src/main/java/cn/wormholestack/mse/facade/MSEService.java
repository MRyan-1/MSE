package cn.wormholestack.mse.facade;

import cn.wormholestack.mse.facade.model.search.SearchReq;
import cn.wormholestack.mse.facade.model.search.SearchRes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @description： MSE核心服务
 * @Author MRyan
 * @Date 2021/11/13 14:58
 * @Version 1.0
 */
@Path("mse")
public interface MSEService {

    /**
     * 搜索
     *
     * @param req
     */
    @POST
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    @Path("search")
    SearchRes search(SearchReq req);

}
