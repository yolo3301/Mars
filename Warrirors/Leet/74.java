public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int j = binarySearch1(matrix, 0, matrix.length - 1, target);
        if (j == -1) return false;
        return binarySearch2(matrix[j], 0, matrix[j].length - 1, target);
    }

    private int binarySearch1(int[][] matrix, int s, int e, int target) {
        if (s > e) return -1;

        int m = (s + e) / 2;
        int len = matrix[0].length;

        if (target >= matrix[m][0] && target <= matrix[m][len - 1])
            return m;
        else if (target < matrix[m][0]) {
            return binarySearch1(matrix, s, m - 1, target);
        } else {
            return binarySearch1(matrix, m + 1, e, target);
        }
    }

    private boolean binarySearch2(int[] nums, int s, int e, int target) {
        if (s > e) return false;
        int m = (s + e) / 2;
        if (nums[m] == target) return true;
        else if (nums[m] < target) {
            return binarySearch2(nums, m + 1, e, target);
        } else {
            return binarySearch2(nums, s, m - 1, target);
        }
    }
}
