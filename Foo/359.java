public class Logger {

    private Map<String, Integer> index;

    /** Initialize your data structure here. */
    public Logger() {
        index = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int last = index.getOrDefault(message, timestamp - 10);
        if (timestamp - last < 10) return false;

        index.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */