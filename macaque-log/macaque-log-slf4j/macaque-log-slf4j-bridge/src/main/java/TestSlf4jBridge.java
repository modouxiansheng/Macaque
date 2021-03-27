import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @program: macaque-log
 * @description: 测试Slf4j的桥接
 * @author: hu_pf
 * @create: 2021-03-27 10:59
 **/
public class TestSlf4jBridge {


    @Test
    public void testLog4jToSlf4j(){
        Logger logger = Logger.getLogger(TestSlf4jBridge.class);

        logger.info("xxxxxx");
    }
}
