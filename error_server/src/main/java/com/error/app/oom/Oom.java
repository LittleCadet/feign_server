package com.error.app.oom;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenxie
 * @date 2020/9/25
 */
//@Service
public class Oom implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        int i = 0;

        Map<Integer, Integer> map = new HashMap(1 , 0.0000001f);

        while(true){
            map.put((int)(Math.random()*Integer.MAX_VALUE) , (int)(Math.random()*Integer.MAX_VALUE) );
            System.out.println(String.format("第 【%s】 次防止" , i++));
            Thread.sleep(100);
        }
    }
}