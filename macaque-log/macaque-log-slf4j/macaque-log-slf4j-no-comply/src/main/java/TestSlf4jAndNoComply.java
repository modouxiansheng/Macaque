import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: macaque-log
 * @description: 没有遵守Slf4j的规范
 * @author: hu_pf
 * @create: 2021-03-27 10:47
 **/
public class TestSlf4jAndNoComply {

    @Test
    public void testLog4j(){

        Logger logger = LoggerFactory.getLogger(TestSlf4jAndNoComply.class);

        logger.info("testLog4j");

    }
}
