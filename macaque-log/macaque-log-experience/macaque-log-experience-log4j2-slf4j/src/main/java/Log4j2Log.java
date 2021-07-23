import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-07-23 10:53
 **/
public class Log4j2Log {


    public void log(){
        Logger LOGGER = LoggerFactory.getLogger(Log4j2Log.class);
        LOGGER.info("Log4j2Log.log");
    }

}
