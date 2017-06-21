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
        int d = 1, res = 0;
        Stack<Iterator<NestedInteger>> stack = new Stack<>();
        stack.push(nestedList.iterator());
        while (!stack.empty()) {
            while (!stack.empty() && !stack.peek().hasNext()) {
                stack.pop();
                d--;
            }

            if (stack.empty()) break;

            NestedInteger n = stack.peek().next();
            if (n.isInteger()) {
                res += n.getInteger() * d;
            } else {
                d++;
                stack.push(n.getList().iterator());
            }
        }

        return res;
    }
}