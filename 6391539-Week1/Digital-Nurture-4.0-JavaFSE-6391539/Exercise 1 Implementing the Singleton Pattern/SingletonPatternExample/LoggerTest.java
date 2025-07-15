package SingletonPatternExample;

public class LoggerTest {
    public static void main(String[] args) {
        MyLogger ref1 = MyLogger.create();
        MyLogger ref2 = MyLogger.create();

        ref1.writeLog("First log message");
        ref2.writeLog("Second log message");

        System.out.println((ref1 == ref2)
            ? "Both ref1 and ref2 are the same instance."
            : "Error: ref1 and ref2 are different instances.");
    }
}
