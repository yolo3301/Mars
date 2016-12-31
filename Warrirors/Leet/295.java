// Shorter version: https://discuss.leetcode.com/topic/27522/java-python-two-heap-solution-o-log-n-add-o-1-find
public class MedianFinder {

    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>(20, Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (min.isEmpty() && max.isEmpty()) {
            min.add(num);
        } else if (!min.isEmpty()) {
            if (num < min.peek()) {
                max.add(num);
            } else {
                min.add(num);
            }
        } else {
            if (num > max.peek()) {
                min.add(num);
            } else {
                max.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (min.size() > max.size()) {
            move(min, max);
        } else {
            move(max, min);
        }

        if ((min.size() + max.size()) % 2 == 0) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            if (min.size() > max.size()) return (double)(min.peek());
            else return (double)(max.peek());
        }
    }

    private void move(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2) {
        int diff = ((q1.size() + q2.size()) % 2 == 0) ? 0 : 1;
        while (q1.size() - q2.size() > diff) {
            q2.add(q1.remove());
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
