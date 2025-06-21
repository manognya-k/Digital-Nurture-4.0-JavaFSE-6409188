class Logger {

    private static Logger objLog;           
    private static Logger objSync;          
    private static volatile Logger objDouble; 

    private Logger() {
        System.out.println("Logger instance created");
    }

    public static Logger getInstance() {
        if (objLog == null) {
            objLog = new Logger();
        }
        return objLog;
    }

    public static synchronized Logger getInstanceSync() {
        if (objSync == null) {
            objSync = new Logger();
            System.out.println("This is the Synchronous Logger");
        }
        return objSync;
    }

    public static Logger getInstanceDouble() {
        if (objDouble == null) {
            synchronized (Logger.class) {
                if (objDouble == null) {
                    objDouble = new Logger();
                }
            }
        }
        return objDouble;
    }
}
