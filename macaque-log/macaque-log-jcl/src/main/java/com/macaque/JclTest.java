package com.macaque;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @program: macaque-log
 * @description: JCL测试日志
 * @author: hu_pf
 * @create: 2021-03-15 14:43
 **/
public class JclTest {

    @Test
    public void testJclLog(){
        // 获取 log日志记录器对象
        Log log = LogFactory.getLog(JclTest.class);
        log.info("hello jcl! :");
    }
}
