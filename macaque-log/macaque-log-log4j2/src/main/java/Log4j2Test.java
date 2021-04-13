import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-04-13 21:48
 **/
public class Log4j2Test {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Log4j2Test.class);

        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
