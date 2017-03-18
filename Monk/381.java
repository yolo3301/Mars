public class RandomizedCollection {

    private Map<Integer, Set<Integer>> index;
    private List<Integer> pool;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        index = new HashMap<>();
        pool = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        if (index.containsKey(val))
            res = false;
        else
            index.put(val, new HashSet<>());

        pool.add(val);
        index.get(val).add(pool.size() - 1);

        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;

        int pos = index.get(val).iterator().next();
        index.get(val).remove(pos);
        if (index.get(val).isEmpty()) index.remove(val);

        if (pos != pool.size() - 1) {
            int rep = pool.get(pool.size() - 1);
            index.get(rep).remove(pool.size() - 1);
            pool.set(pos, rep);
            index.get(rep).add(pos);
        }
        pool.remove(pool.size() - 1);

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return pool.get(rand.nextInt(pool.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */