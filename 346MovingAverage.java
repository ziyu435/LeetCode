import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> q;
    int size, itemCount, windowSum;
    // Using cache to maintain the count and sum of items in the window

    public MovingAverage(int size) {
        this.size = size;
        this.itemCount = 0;
        this.windowSum = 0;
        q = new LinkedList<>();
    }

    public double next(int val) {
        q.offer(val);
        itemCount++;
        windowSum += val;
        if(itemCount == size + 1) {
            windowSum -= q.poll();
            itemCount--;
        }
        return (double)windowSum/itemCount;
        //Remember to do the casting. Either windowSum or itemCount is ok.
    }
}
