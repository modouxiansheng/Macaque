package com.macaque;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-15 15:29
 **/
public class Log4jTest {

    @Test
    public void testLog4j(){

        // 获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);

        for (int i = 0; i < 10000; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }
    }
}
