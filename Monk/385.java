/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.length() == 0) return null;
        Stack<NestedInteger> stack = new Stack<>();
        int i = 0;
        NestedInteger res = null;

        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                stack.push(new NestedInteger());
                i++;
            } else if (s.charAt(i) == ']') {
                NestedInteger n = stack.pop();
                if (stack.empty()) {
                    res = n;
                } else {
                    stack.peek().add(n);
                }
                i++;
            } else if (s.charAt(i) != ',') {
                int j = i;
                while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
                    j++;
                }
                
                if (j > i) {
                    int val = Integer.valueOf(s.substring(i, j));
                    i = j;
                    NestedInteger n = new NestedInteger(val);
    
                    if (stack.empty()) {
                        res = n;
                    } else {
                        stack.peek().add(n);
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        return res == null ? stack.pop() : res;
    }
}