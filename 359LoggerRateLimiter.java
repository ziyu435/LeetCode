import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Logger {
    public HashMap<String, Integer> logs;

    /** Initialize your data structure here. */
    public Logger() {
        this.logs = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.logs.containsKey(message)) {
            this.logs.put(message,timestamp);
            return true;
        } else {
            int oldTimestamp = this.logs.get(message);
            if(timestamp - oldTimestamp >= 10) {
                this.logs.put(message,timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}
/**
 * PS:
 * When this message isn't going to be printed, you should not update the hashmap!!!
 * */


/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
