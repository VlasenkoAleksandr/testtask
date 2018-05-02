package deflogger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestsLogger {
    protected static Logger Log = LogManager.getLogger();

    public static void logTestCaseStart(String testCaseName){
        Log.info("---------------------------\n");
        Log.info(testCaseName + " started");
        Log.info("\n---------------------------");

    }

    public static void logTestCaseEnd(String testCaseName){
        Log.info("---------------------------\n");
        Log.info(testCaseName + " ended");
        Log.info("\n---------------------------");

    }

    public static void info(String message){
        Log.info(message);
    }

    public static void error(String message){
        Log.error("\n!!!!!!!!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!!!!!\n");
        Log.error(message);
    }

    public static void logMethodName(){
        int j = 1;
        Throwable t = new Throwable();
        StackTraceElement[] stackTraceElements= t.getStackTrace();
        String fullClassPath = stackTraceElements[j].getClassName();
        String[] path = fullClassPath.split("\\.");
        String className = path[( path.length - 1 )];
        info(className + "." + stackTraceElements[j].getMethodName());

    }
}
