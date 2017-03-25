public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            if (num > maxHeap.peek()) {
                if (minHeap.size() == maxHeap.size()) {
                    if (!minHeap.isEmpty() && num >= minHeap.peek()) {
                        maxHeap.add(minHeap.remove());
                        minHeap.add(num);
                    } else {
                        maxHeap.add(num);
                    }
                } else
                    minHeap.add(num);
            } else {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.remove());
                }
                maxHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double)maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */