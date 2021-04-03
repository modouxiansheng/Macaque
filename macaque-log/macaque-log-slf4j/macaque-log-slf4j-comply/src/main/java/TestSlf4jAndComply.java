import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: macaque-log
 * @description: 遵守了Slf4j规范
 * @author: hu_pf
 * @create: 2021-03-27 10:31
 **/
public class TestSlf4jAndComply {



    @Test
    public void testLogback(){
        Logger logger = LoggerFactory.getLogger(TestSlf4jAndComply.class);

        logger.info("testLogback");

    }
}
