
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-07-23 10:54
 **/
public class Log4j2LogTest {


    @Test
    public void test(){
        Logger logger = LogManager.getLogger("Log4j2LogTest");

        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
