public class Logger {
    private static volatile Logger instance;
    private int logCount;
    private Logger() {
        logCount = 0;
        System.out.println("Logger instance created!");
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }
    public int getLogCount() {
        return logCount;
    }
}
class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===\n");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Are logger1 and logger2 the same instance? "
                + (logger1 == logger2));
        logger1.log("Application has started");
        logger1.log("User logged in successfully");
        logger2.log("Fetching data from database");
        System.out.println("\nTotal logs written: " + logger2.getLogCount());
        System.out.println("\nHashCode of logger1: " + logger1.hashCode());
        System.out.println("HashCode of logger2: " + logger2.hashCode());
        System.out.println("(Same hashcode means same object in memory)");
    }
}
