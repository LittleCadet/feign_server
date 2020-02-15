package com.feign.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LittleCadet
 * @Date 2020/2/4
 */
@RestController
@RequestMapping("/feign")
public class FeignController
{
    @PostMapping("/provider")
    public String showInfo(){
        return "feign_provider:verison2";
    }

}
