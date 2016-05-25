package com.dlut.jky.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.dlut.jky.app1.Services.AlgorithmService;
import com.dlut.jky.app1.Services.ClassiferService;
import com.dlut.jky.app1.beans.Algorithm;
import com.dlut.jky.app1.beans.Classifer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jiangkunyou on 15/12/3.
 */
public class AlgorithmNew {

    @Autowired
    private ClassiferService classiferService;

    public void execute(Context context) {
        injectClassifer(context);
    }

    private void injectClassifer(Context context) {
        List<Classifer> classifers = classiferService.getClassifers();
        context.put("classifers", classifers);
    }
}
