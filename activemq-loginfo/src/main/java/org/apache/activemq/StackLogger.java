package org.apache.activemq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StackLogger {
    private static final Logger LOG = LoggerFactory.getLogger(StackLogger.class);
    public StackLogger() {

    }

    public static void logStack(Logger logger, int deep, String logLevel){
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        int deepth = 0;
        String logInfo = null;
        for (StackTraceElement stackTraceElement:traceElements){
            if (deepth++<=deep){
                logInfo += stackTraceElement.toString() + "*";
            }
        }
        log(logger, logLevel, logInfo);
    }

    public static void logStack(Logger logger, int deep, String logLevel, String logInfo){
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        int deepth = 0;
        String logInfo1 = logInfo + "\n";
        for (StackTraceElement stackTraceElement:traceElements){
            if (deepth++ <= deep){
                logInfo1 += stackTraceElement.toString() + "*";
            }
        }
        log(logger, logLevel, logInfo1);
    }

    private static void log(Logger logger, String loglevel, String loginfo){
        Logger innerLogger = logger;
        if (logger == null){
            innerLogger = LOG;
        }

        switch(loglevel.toLowerCase()){
            case "trace":{
                innerLogger.trace(loginfo);
                break;
            }
            case "debug":{
                innerLogger.debug(loginfo);
                break;
            }
            case "info":{
                innerLogger.info(loginfo);
                break;
            }
            case "warn":{
                innerLogger.warn(loginfo);
                break;
            }
            case "error":{
                innerLogger.error(loginfo);
                break;
            }
        }
    }
}
