package com.dlut.jky.app1.module.action;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.FormField;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.dlut.jky.app1.Services.MessageService;
import com.dlut.jky.app1.beans.Algorithm;
import com.dlut.jky.app1.beans.Classifer;
import com.dlut.jky.app1.beans.Message;
import com.dlut.jky.app1.beans.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by jiangkunyou on 15/12/7.
 */
public class InsertMessageAction {

    @Autowired
    private MessageService messageService;

    @Autowired
    private HttpServletRequest request;

    public void doInsertMessage(@FormGroup("message") Message message,
                                Navigator nav, TurbineRunData runData) {
        insertMessage(message);
    }

    // 插入留言
    private void insertMessage(Message message) {
        User user = (User) request.getSession().getAttribute("user");
        message.setUserId(user.getUserId());
        message.setUserName(user.getUserName());
        message.setMessageDate(new Date());
        messageService.insertMessage(message);
    }
}
