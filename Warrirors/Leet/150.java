public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String t : tokens) {
            switch (t) {
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    st.push(-st.pop() + st.pop());
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    int v2 = st.pop(), v1 = st.pop();
                    st.push(v1 / v2);
                    break;
                default:
                    st.push(Integer.parseInt(t));
            }
        }

        return st.peek();
    }
}
