/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 // reference https://discuss.leetcode.com/topic/44983/share-my-java-neat-solution-8ms
public class NestedIterator implements Iterator<Integer> {

    private NestedInteger nextInt;
    private Stack<Iterator<NestedInteger>> s;

    public NestedIterator(List<NestedInteger> nestedList) {
        nextInt = null;
        s = new Stack<>();
        s.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt == null ? null : nextInt.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!s.empty()) {
            if (!s.peek().hasNext()) s.pop();
            else if (s.peek().next().isInteger()) {
                nextInt = s.peek().next();
                return true;
            } else {
                s.push(nextInt.getList().iterator());
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
