package SingletonPatternExample;

public class MyLogger {
    private static MyLogger onlyLogger = null;

    private MyLogger() {
        System.out.println("Logger instance created!");
    }

    public static MyLogger create() {
        if (onlyLogger == null) {
            synchronized (MyLogger.class) {
                if (onlyLogger == null) {
                    onlyLogger = new MyLogger();
                }
            }
        }
        return onlyLogger;
    }

    public void writeLog(String logText) {
        System.out.println("[LOG]: " + logText);
    }
}
