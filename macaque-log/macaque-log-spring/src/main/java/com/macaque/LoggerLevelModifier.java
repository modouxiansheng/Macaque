package com.macaque;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * 动态修改日志级别
 * <p/>
 * <a href="https://tech.meituan.com/2017/02/17/change-log-level.html">日志级别动态调整——小工具解决大问题</a>
 *
 * @author <a href=mailto:ktyi@iflytek.com>伊开堂</a>
 * @date 2020/5/8
 */
public class LoggerLevelModifier {
    private static final Logger logger = LoggerFactory.getLogger(LoggerLevelModifier.class);

    private static LogFrameworkType logFrameworkType;
    private static ConcurrentMap<String, Object> loggerMap = new ConcurrentHashMap<>();

    public static void init() {
        // slf4j找org/slf4j/impl/StaticLoggerBinder.class类, 有些是默认实现(logback), 有些是桥接包(log4j/2)
        logFrameworkType = LogFrameworkType.LOG4J2;
        org.apache.logging.log4j.core.LoggerContext loggerContext =
                (org.apache.logging.log4j.core.LoggerContext) org.apache.logging.log4j.LogManager
                        .getContext(false);
        Map<String, org.apache.logging.log4j.core.config.LoggerConfig> map = loggerContext.getConfiguration().getLoggers();
        for (org.apache.logging.log4j.core.config.LoggerConfig loggerConfig : map.values()) {
            String key = loggerConfig.getName();
            if (isBlank(key)) {
                key = "root";
            }
            loggerMap.put(key, loggerConfig);
        }
    }

    private static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        else {
            return true;
        }
    }

    public static Map<String, Object> getLoggerList() {
        Map<String, Object> result = new HashMap<>();
        result.put("logFramework", logFrameworkType);

        List<Map<String, String>> loggerList = new ArrayList<>();
        for (ConcurrentMap.Entry<String, Object> entry : loggerMap.entrySet()) {
            Map<String, String> loggerInfo = new HashMap<>();
            loggerInfo.put("loggerName", entry.getKey());
            org.apache.logging.log4j.core.config.LoggerConfig targetLogger = (org.apache.logging.log4j.core.config.LoggerConfig) entry.getValue();
            loggerInfo.put("logLevel", targetLogger.getLevel().toString());
            loggerList.add(loggerInfo);
        }
        result.put("loggerList", loggerList);

        logger.info("getLoggerList: result={}", result);
        return result;
    }

    public static String setLogLevel(String loggerName, String level) {
        Object logger = loggerMap.get(loggerName);
        org.apache.logging.log4j.core.config.LoggerConfig loggerConfig =
                (org.apache.logging.log4j.core.config.LoggerConfig) logger;
        org.apache.logging.log4j.Level targetLevel = org.apache.logging.log4j.Level.toLevel(level);
        loggerConfig.setLevel(targetLevel);
        org.apache.logging.log4j.core.LoggerContext ctx =
                (org.apache.logging.log4j.core.LoggerContext) org.apache.logging.log4j.LogManager
                        .getContext(false);
        ctx.updateLoggers(); // This causes all Loggers to refetch information from their LoggerConfig.
        return "success";
    }

    private class LogConstant {
        public static final String LOGBACK_LOGGER_FACTORY = "ch.qos.logback.classic.util.ContextSelectorStaticBinder";
        public static final String LOG4J2_LOGGER_FACTORY = "org.apache.logging.slf4j.Log4jLoggerFactory";
        public static final String LOG4J_LOGGER_FACTORY = "org.slf4j.impl.Log4jLoggerFactory";
    }

    private enum LogFrameworkType {
        LOG4J,
        LOGBACK,
        LOG4J2,
        UNKNOWN
    }
}