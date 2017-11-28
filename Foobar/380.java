class RandomizedSet {

    Map<Integer, Integer> index;
    List<Integer> pool;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        index = new HashMap<>();
        pool = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.containsKey(val)) return false;
        index.put(val, pool.size());
        pool.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;
        int idx = index.get(val);
        pool.set(idx, pool.get(pool.size()-1));
        index.put(pool.get(pool.size()-1), idx);
        pool.remove(pool.size()-1);
        index.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = random.nextInt(pool.size());
        return pool.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */