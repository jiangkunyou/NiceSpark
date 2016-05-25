package com.dlut.jky.app1.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by jiangkunyou on 15/11/8.
 * 留言类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    // 留言编号
    private int messageId;

    // 留言作者编号
    private int userId;

    private String userName;

    // 留言创建时间
    private Date messageDate;

    // 留言内容
    private String messageCont;
}
