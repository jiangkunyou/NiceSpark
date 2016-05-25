package com.dlut.jky.app1.Services;

import com.dlut.jky.app1.beans.Message;
import com.dlut.jky.app1.beans.Page;
import com.dlut.jky.app1.dao.factories.DaoFactory;
import com.dlut.jky.app1.dao.inters.MessageDao;
import lombok.NoArgsConstructor;

/**
 * Created by jiangkunyou on 15/11/23.
 */
@NoArgsConstructor
public class MessageService {
    private MessageDao messageDao = DaoFactory.getInstance().getDao("messageDaoType");
    public Page<Message> getPageByPageNo(int pageNo, int pageSize){
        return messageDao.getPageByPageNo(pageNo, pageSize);
    }

    public void insertMessage(Message message) {
        messageDao.insertMessage(message);
    }
}
