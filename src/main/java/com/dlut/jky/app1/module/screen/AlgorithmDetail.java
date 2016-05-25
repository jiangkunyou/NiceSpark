package com.dlut.jky.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.dlut.jky.app1.Services.AlgorithmService;
import com.dlut.jky.app1.beans.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

/**
 * Created by jiangkunyou on 15/11/30.
 */
public class AlgorithmDetail {

    @Autowired
    private AlgorithmService algorithmService;

    public void execute(@Param("algorId") String algorId, Context context, Navigator nav) {
        injectAlgorithm(algorId, context, nav);
    }

    // 根据id获取算法对象,并传给前端模板
    private void injectAlgorithm(String algorId, Context context, Navigator nav){
        try {
            Algorithm algorithm = algorithmService.getAlgorithmById(Integer.parseInt(algorId));
            context.put("algorithm", algorithm);
        } catch (Exception e) {
            Logger.getGlobal().info("");
            nav.redirectTo("app1Link").withTarget("404.vm");
        }
    }

}
