package com.dlut.jky.app1.dao.impls;

import com.dlut.jky.app1.beans.Message;
import com.dlut.jky.app1.beans.Page;
import com.dlut.jky.app1.dao.inters.MessageDao;

import java.util.List;

/**
 * Created by jiangkunyou on 15/11/8.
 */
public class MessageDbutilsDaoImpl extends DbUtilsDaoImpl<Message> implements MessageDao {

    @Override
    public void insertMessage(Message message) {
        String sql = "INSERT INTO message(userId, userName, messageDate, messageCont) VALUES(?, ?, ?, ?)";
        update(sql, message.getUserId(), message.getUserName(), message.getMessageDate(), message.getMessageCont());
    }

    @Override
    public void deleteMessage(Integer id) {
        String sql = "DELETE FROM message WHERE messageId = ?";
        update(sql, id);
    }

    @Override
    public void updateMessage(Message message) {
        String sql = "UPDATE message SET messageDate = ?, messageCont = ? WHERE messageId = ?";
        update(sql, message.getMessageDate(), message.getMessageCont(), message.getMessageId());
    }

    @Override
    public Message getMessageById(Integer id) {
        String sql = "SELECT * FROM message WHERE messageId = ?";
        return get(sql, id);
    }

    @Override
    public List<Message> getMessages(Object... args) {
        String sql = "SELECT * FROM message";
        return getForList(sql, args);
    }

    @Override
    public long getTotalMessageNumber() {
        String sql = "SELECT COUNT(*) FROM message";
        return getForValue(sql);
    }

    @Override
    public Page<Message> getPageByPageNo(int pageNo, int pageSize) {
        String sql = "SELECT * FROM message LIMIT ?,?";
        Page<Message> page = new Page<Message>(pageNo, pageSize, getTotalMessageNumber());
        // 获取当前页前共有多少个元素
        int prevNumber = (page.getPageNo() - 1) * pageSize;
        List<Message> list = getForList(sql, prevNumber, pageSize);
        page.setItems(list);
        return page;
    }
}
