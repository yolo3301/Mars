// LOL cheating
public class RandomizedSet {

    private Map<Integer, Integer> index;
    private Set<Integer> empty;
    private List<Integer> pool;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        index = new HashMap<>();
        empty = new HashSet<>();
        pool = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.containsKey(val)) return false;
        if (empty.isEmpty()) {
            pool.add(val);
            index.put(val, pool.size() - 1);
        } else {
            int fill = empty.iterator().next();
            pool.set(fill, val);
            index.put(val, fill);
            empty.remove(fill);
        }

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;

        int pos = index.get(val);
        empty.add(pos);
        index.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        while (true) {
            int rand = new Random().nextInt(pool.size());
            if (!empty.contains(rand)) {
                return pool.get(rand);
            }
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

 public class RandomizedSet {

    private Map<Integer, Integer> index;
    private List<Integer> pool;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        index = new HashMap<>();
        pool = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.containsKey(val)) return false;
        pool.add(val);
        index.put(val, pool.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;
        int pos = index.get(val);
        pool.set(pos, pool.get(pool.size() - 1));
        pool.remove(pool.size() - 1);
        if (pos < pool.size())
            index.put(pool.get(pos), pos);
        index.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return pool.get(rand.nextInt(pool.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
