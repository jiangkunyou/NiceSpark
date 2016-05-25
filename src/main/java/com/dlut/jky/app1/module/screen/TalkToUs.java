package com.dlut.jky.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.dlut.jky.app1.Services.MessageService;
import com.dlut.jky.app1.beans.Message;
import com.dlut.jky.app1.beans.Page;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiangkunyou on 15/12/6.
 */
public class TalkToUs {

    @Autowired
    private MessageService messageService;

    public void execute(@Param(value = "pageNo") String pageNo, Context context) {
        injectMessagePage(pageNo, context);
    }

    private void injectMessagePage(String pageNo, Context context) {
        int pageNo_int;
        try {
            pageNo_int = Integer.parseInt(pageNo);
        } catch (Exception e) {
            pageNo_int = 1;
        }
        Page<Message> myPage = messageService.getPageByPageNo(pageNo_int, 5);
        context.put("myPage", myPage);
    }

}
