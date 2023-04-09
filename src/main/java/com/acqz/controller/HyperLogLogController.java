package com.acqz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haofeng
 * @date 2023/4/9 9:29
 */
@Api(description = "案例实战总03:天猫亿级UV的Redis统计方案")
@RestController
@Slf4j
public class HyperLogLogController {
    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("获得IP去重后的首页访问量")
    @RequestMapping(value = "/uv",method = RequestMethod.GET)
    public long uv()
    {
        //pfcount key 统计 key 的估算值
        return redisTemplate.opsForHyperLogLog().size("hll");
    }
}
