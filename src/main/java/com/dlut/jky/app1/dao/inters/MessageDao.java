package com.dlut.jky.app1.dao.inters;

import com.dlut.jky.app1.beans.Message;
import com.dlut.jky.app1.beans.Page;

import java.util.List;

/**
 * Created by jiangkunyou on 15/11/8.
 */
public interface MessageDao {

    void insertMessage(Message message);

    void deleteMessage(Integer id);

    void updateMessage(Message message);

    Message getMessageById(Integer id);

    List<Message> getMessages(Object... args);

    // 获取总留言数
    long getTotalMessageNumber();

    /**
     * 获取page对象
     * @param pageNo: 页码
     * @param pageSize: 每页元素个数
     */
    Page<Message> getPageByPageNo(int pageNo, int pageSize);
}
