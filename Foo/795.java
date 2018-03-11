class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length;
        int ret = 0;

        for (int i = 1; i <= len; i++) {
            Deque<Integer> deq = new LinkedList<>();
            for (int j = 0; j < len; j++) {
                if (!deq.isEmpty() && deq.peekFirst() == j - i)
                    deq.removeFirst();
                while (!deq.isEmpty() && A[deq.peekLast()] < A[j]) {
                    deq.removeLast();
                }
                deq.addLast(j);
                
                //System.out.println(deq);

                if (j >= i-1 && A[deq.peekFirst()] >= L && A[deq.peekFirst()] <= R) {
                    //System.out.println("added");
                    ret++;
                }
            }
        }

        return ret;
    }
}

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ret = 0, cnt = 0, j = 0;
        // j is the last index
        // cnt is the # of subarrays that can end at the current index

        for (int i = 0; i < A.length; i++) {
            if (L <= A[i] && A[i] <= R) {
                ret += i - j + 1;
                cnt = i - j + 1;
            } else if (A[i] < L) {
                ret += cnt;
            } else {
                j = i + 1;
                cnt = 0;
            }
        }

        return ret;
    }
}