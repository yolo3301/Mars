// Can be optimized with BST recording number of children
public class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer v1, Integer v2) {
            return v2.compareTo(v1);
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new double[0];
        int size = Math.max(nums.length - k + 1, 1);
        double[] res = new double[size];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                res[i-k] = getMedian();
                remove(nums[i-k]);
            }

            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return res;
    }

    private void add(int n) {
        if (n >= getMedian()) {
            minHeap.add(n);
        } else {
            maxHeap.add(n);
        }

        if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.remove());

        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.remove());
    }

    private void remove(int n) {
        if (n >= getMedian()) {
            minHeap.remove(n);
        } else {
            maxHeap.remove(n);
        }

        if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.remove());

        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.remove());
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        } else {
            return (double)(minHeap.peek());
        }
    }

}
