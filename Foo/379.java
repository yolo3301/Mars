public class PhoneDirectory {

    private Set<Integer> used;
    private Queue<Integer> queue;
    private int max;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        queue = new LinkedList<>();
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            queue.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) return -1;
        int res = queue.remove();
        used.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= max) return false;
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) {
            queue.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */