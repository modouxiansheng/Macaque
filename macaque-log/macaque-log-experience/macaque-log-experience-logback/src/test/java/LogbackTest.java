import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-15 16:23
 **/
public class LogbackTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void testLogback(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }


    @Test
    public void logTest(){
        Log4j2Log log4j2Log = new Log4j2Log();
        log4j2Log.log();
        LOGGER.info("xxxx");
    }
}
