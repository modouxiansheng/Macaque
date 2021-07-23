import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-07-23 10:53
 **/
public class Log4j2Log {


    public void log(){
        Logger logger = LogManager.getLogger("Log4j2Log");
        logger.info("Log4j2Log.log");
    }

}
