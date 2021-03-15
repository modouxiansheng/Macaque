package com.macaque;

import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @program: macaque-log
 * @description: 测试JUL日志
 * @author: hu_pf
 * @create: 2021-03-15 14:30
 **/
public class JulLogTest {


    @Test
    public void testLog(){
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.macaque.JulLogTest");
        // 2.日志记录输出
        logger.info("hello jul");
        // 通用方法进行日志记录
        logger.log(Level.INFO,"info msg");
        // 通过占位符 方式输出变量值
        String name = "macaque";
        Integer age = 13;
        logger.log(Level.INFO,"用户信息：{0},{1}",new Object[]{name,age});
    }

    @Test
    public void testLevel(){
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.macaque.JulLogTest");

        // 关闭系统默认配置
        logger.setUseParentHandlers(false);
        // 自定义配置日志级别
        // 创建ConsolHhandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);


        // 配置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);


        logger.severe("severe");
        logger.warning("waring");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    // Logger对象父子关系
    @Test
    public void testLogParent()throws Exception{

        Logger logger1 = Logger.getLogger("com.macaque.JulLogTest");
        Logger logger2 = Logger.getLogger("com");

        // 测试
        System.out.println(logger1.getParent() == logger2);
        // 所有日志记录器的顶级父元素 LogManager$RootLogger，name ""
        System.out.println("logger2 Parent:"+logger2.getParent() + ",name:" + logger2.getParent().getName());

        // 关闭默认配置
        logger2.setUseParentHandlers(false);

        // 设置logger2日志级别
        // 自定义配置日志级别
        // 创建ConsolHhandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);


        // 配置日志具体级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }

}
