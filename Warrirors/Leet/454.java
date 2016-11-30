public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        int[] arr1 = new int[len * len];
        int[] arr2 = new int[len * len];

        int k = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr1[k] = A[i] + B[j];
                arr2[k] = C[i] + D[j];
                k++;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = arr1.length - 1, res = 0;
        while (i < arr1.length && j >= 0) {
            int a1 = arr1[i], a2 = arr2[j];
            int sum = a1 + a2;
            if (sum == 0) {
                int c1 = 0, c2 = 0;
                while (i < arr1.length && arr1[i] == a1) {
                    c1++;
                    i++;
                }
                while (j >= 0 && arr2[j] == a2) {
                    c2++;
                    j--;
                }
                res += c1 * c2;
            } else if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
