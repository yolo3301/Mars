class MyStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        top();
        q1.remove();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    // Get the top element.
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
