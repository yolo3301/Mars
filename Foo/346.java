public class MovingAverage {

    private Deque<Integer> deque;
    private int size, sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.deque = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (deque.size() < size) {
            deque.addLast(val);
            sum += val;
            return (double)sum / deque.size();
        } else {
            sum -= deque.removeFirst();
            deque.addLast(val);
            sum += val;
            return (double)sum / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */