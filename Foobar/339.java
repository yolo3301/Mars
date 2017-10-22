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
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0, level = 1;
        Stack<Iterator<NestedInteger>> stack = new Stack<>();
        Iterator<NestedInteger> iter = nestedList.iterator();
        while (iter.hasNext() || !stack.empty()) {
            while (!iter.hasNext() && !stack.empty()) {
                iter = stack.pop();
                level--;
            }

            if (!iter.hasNext() && stack.empty()) break;

            NestedInteger next = iter.next();
            if (next.isInteger()) {
                res += level * next.getInteger();
            } else {
                stack.push(iter);
                iter = next.getList().iterator();
                level++;
            }
        }

        return res;
    }
}
