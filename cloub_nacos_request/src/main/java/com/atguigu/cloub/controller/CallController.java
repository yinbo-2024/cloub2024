package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class CallController {

//  private static final String UserDao_Url="http://localhost:8001";
    private static final String UserDao_Url="http://cloub-nacos-dao";
    @Value("${service-url.cloub-nacos-dao}")
    private String Service_Url;
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/people/user-info/addUser2024")
    public ResponseResult RequestAddPerson(@RequestBody  UserDTO userDTO){
       return restTemplate.postForObject(UserDao_Url+"/user-info/addUser2024",userDTO,ResponseResult.class);
    }

    @RequestMapping("/people/user-info/findUser2024Byid/{id}")
    public ResponseResult RequestFindPerson(@PathVariable("id") String id){
      return restTemplate.postForObject(UserDao_Url+"/user-info/findUser2024Byid/"+id,id,ResponseResult.class);
  }


    @RequestMapping("/people/user-nacos/findUser2024Byid/{id}")
    public ResponseResult FindPerson(@PathVariable("id") String id){
        return restTemplate.postForObject(Service_Url+"/user-info/findUser2024Byid/"+id,id,ResponseResult.class);
    }

    @RequestMapping("/people/nacos/findPort")
    public ResponseResult FindPerson(){
        return restTemplate.postForObject(Service_Url+"/nacos/findPort","",ResponseResult.class);
    }

}
