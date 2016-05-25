package com.dlut.jky.app1.listeners;

import com.dlut.jky.app1.dao.factories.DaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by jiangkunyou on 15/11/17.
 */
public class MyListener implements ServletContextListener {

    /**
     * 在web应用被创建出来时运行, 可以在这里进行数据库连接池的创建, spring IOC容器加载等操作
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        InputStream in = servletContextEvent.getServletContext().getClass().getClassLoader().getResourceAsStream("daoType.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(in);
//            DaoFactory.getInstance().setProperties(properties);
//        } catch (IOException e) {
//            Logger.getGlobal().info("contextInitialzed error");
//            e.printStackTrace();
//        }
    }

    /**
     * 在web应用被卸载时运行
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
