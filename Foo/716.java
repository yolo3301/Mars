class MaxStack {

    TreeMap<Integer, Integer> tree; // index => value
    Map<Integer, List<Integer>> map; // value => indices
    TreeMap<Integer, Integer> max;
    int index = 0;

    /** initialize your data structure here. */
    public MaxStack() {
        tree = new TreeMap<>();
        map = new HashMap<>();
        max = new TreeMap<>();
    }
    
    public void push(int x) {
        index++;
        tree.put(index, x);
        map.computeIfAbsent(x, e -> new ArrayList<>()).add(index);
        max.put(x, max.getOrDefault(x, 0)+1);
    }
    
    public int pop() {
        int k = tree.lastKey();
        int ret = tree.remove(k);
        map.get(ret).remove(map.get(ret).size()-1);
        if (map.get(ret).isEmpty()) map.remove(ret);
        max.put(ret, max.get(ret)-1);
        if (max.get(ret) == 0) max.remove(ret);
        
        return ret;
    }
    
    public int top() {
        return tree.lastEntry().getValue();
    }
    
    public int peekMax() {
        return max.lastKey();
    }
    
    public int popMax() {
        int ret = max.lastKey();
        max.put(ret, max.get(ret)-1);
        if (max.get(ret) == 0) max.remove(ret);

        int idx = map.get(ret).get(map.get(ret).size()-1);
        map.get(ret).remove(map.get(ret).size()-1);
        if (map.get(ret).isEmpty()) map.remove(ret);

        tree.remove(idx);

        return ret;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
