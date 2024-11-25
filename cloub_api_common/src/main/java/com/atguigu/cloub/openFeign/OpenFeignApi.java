package com.atguigu.cloub.openFeign;

import com.atguigu.cloub.common.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * cloub-consul-dao 服务对外提供的 接口
 * 对外 提供 可以 调用的 接口
 */
//@FeignClient("cloub-consul-dao")
@FeignClient("cloub-gateway")
public interface OpenFeignApi {


    /**
     *  根据主键id查询表user2024信息
     *  @param id
     */
    @RequestMapping("/gateway/gateway2024Byid/{id}")
    public ResponseResult  gateway2024Byid(@PathVariable("id") String id) ;

    /**
     *  根据主键id查询表user2024信息
     *  @param id
     */
    @RequestMapping("/consul/findUser2024Byid/{id}")
    public ResponseResult findUser2024Byid(@PathVariable("id") String id);



    /**
     *  检验 负载均衡
     * @return
     */
    @RequestMapping("/consul/getConsul")
    public String getLb();


    /**
     * openFeign  请求时间测试
     * @param id
     * @return
     */
    @RequestMapping("/consul/findUsersById/{id}")
    public ResponseResult findUsersById(@PathVariable("id") String id);



    /**
     * openFeign  断路器 测试
     * @param id
     * @return
     */
    @RequestMapping("/consul/circuit/{id}")
    public String circuit(@PathVariable("id") String id );



    /**
     *  信号量 舱壁 测试
     * @param id
     * @return
     */
    @RequestMapping("/consul/bulkhead/{id}")
    public String bulkhead(@PathVariable("id") String id );


    /**
     *  链路追踪 测试
     * @param id
     * @return
     */
    @RequestMapping("/zipkin/getId/{id}")
    public String getZipKin(@PathVariable("id") String id);



}
