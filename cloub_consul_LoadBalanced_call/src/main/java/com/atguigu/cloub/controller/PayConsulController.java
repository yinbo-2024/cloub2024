package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PayConsulController {

    private static final String Pay_Url="http://cloub-consul-dao";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consulCall/consul/findUser2024Byid/{id}")
    public ResponseResult responseResult(@PathVariable("id") String id){
       return restTemplate.postForObject(Pay_Url+"/consul/findUser2024Byid/"+id,id,ResponseResult.class);
    }


    @RequestMapping("/consulCall/consul/getConsul")
    public String getConsulInfo(){
        return restTemplate.getForObject(Pay_Url+"/consul/getConsul",String.class);
    }



    @Autowired
    private DiscoveryClient discoveryclient;
    @RequestMapping("/consulCall/discovery")
    public String discovery(){
        List<String> services =discoveryclient.getServices();
        for(String element:services) {
            System.out.println(element);
        }
            System.out.println("=s=================================");
            List<ServiceInstance> instances = discoveryclient.getInstances("cloub-consul-dao");
            for(ServiceInstance element:instances) {
                System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
            }
            return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }


}
