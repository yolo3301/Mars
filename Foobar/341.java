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
public class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack;
    private NestedInteger nextVal;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        this.stack.push(nestedList.iterator());
        this.nextVal = null;
    }

    @Override
    public Integer next() {
        if (this.nextVal == null) return null;
        return this.nextVal.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) stack.pop();
            else if ((this.nextVal = stack.peek().next()).isInteger()) {
                return true;
            } else {
                stack.push(this.nextVal.getList().iterator());
            }
        }

        this.nextVal = null;
        return false;
        // while (!stack.empty() && !stack.peek().hasNext()) {
        //     stack.pop();
        // }
        // NestedInteger n = null;
        // while (!stack.empty() && stack.peek().hasNext() && !(n = stack.peek().next()).isInteger()) {
        //     if (n.getList().isEmpty()) continue;
        //     stack.push(n.getList().iterator());
        // }

        // this.nextVal = n;

        // return this.nextVal != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

