public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int[] count = new int[nums.length];
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(arr, count, 0, nums.length - 1);

        return IntStream.of(count).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int[][] arr, int[] count, int s, int e) {
        if (s >= e) return;

        int m = s + (e - s) / 2;
        mergeSort(arr, count, s, m);
        mergeSort(arr, count, m + 1, e);

        int[][] tmp = new int[e-s+1][2];
        int i = s, j = m + 1, k = 0;
        while (i <= m && j <= e) {
            if (arr[i][0] <= arr[j][0]) {
                tmp[k][0] = arr[i][0];
                tmp[k][1] = arr[i][1];

                count[arr[i][1]] += j - m - 1;

                k++;
                i++;
            } else {
                tmp[k][0] = arr[j][0];
                tmp[k][1] = arr[j][1];
                k++;
                j++;
            }
        }

        while (i <= m) {
            tmp[k][0] = arr[i][0];
            tmp[k][1] = arr[i][1];

            count[arr[i][1]] += j - m - 1;

            k++;
            i++;
        }

        while (j <= e) {
            tmp[k][0] = arr[j][0];
            tmp[k][1] = arr[j][1];
            k++;
            j++;
        }

        for (int p = s, q = 0; p <= e; p++, q++) {
            arr[p][0] = tmp[q][0];
            arr[p][1] = tmp[q][1];
        }
    }
}

public class Solution {
    public class Node {
        public int dup;
        public int count;
        public int val;
        public Node left;
        public Node right;

        public Node(int v) {
            dup = 1;
            count = 0;
            val = v;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        Integer[] res = new Integer[nums.length];
        res[nums.length - 1] = 0;
        Node root = new Node(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            insert(root, res, nums, i, 0);
        }

        return Arrays.asList(res);
    }

    private void insert(Node node, Integer[] res, int[] nums, int index, int sum) {
        if (node.val == nums[index]) {
            node.dup++;
            res[index] = sum + node.count;
            return;
        }

        if (nums[index] < node.val) {
            node.count++;
            if (node.left == null) {
                Node curr = new Node(nums[index]);
                node.left = curr;
                res[index] = sum;
            } else {
                insert(node.left, res, nums, index, sum);
            }
        } else {
            if (node.right == null) {
                Node curr = new Node(nums[index]);
                node.right = curr;
                res[index] = sum + node.count + node.dup;
            } else {
                insert(node.right, res, nums, index, sum + node.count + node.dup);
            }
        }
    }
}
