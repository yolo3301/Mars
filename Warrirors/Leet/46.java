// My original solution, not sure why the performance is so BAD...
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        res.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
        while (getNext(nums)) {
          res.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))));
        }
    }

    private boolean getNext(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) {
          i--;
        }

        if (i < 0) return false;

        // can use binary search to boost performance
        int j = nums.length - 1;
        while (nums[j] < nums[i]) {
            j--;
        }

        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;

        reverse(nums, i + 1, nums.length - 1);

        return true;
    }

    private void reverse(int[] nums, int s, int e) {
      for (int i = 0; i < (e - s) / 2; i++) {
          int tmp = nums[s + i];
          nums[s + i] = nums[e - i];
          nums[e - i] = tmp;
      }
    }
}



// Better using BT
public class Solution {
  public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      if (nums.length == 0) return res;
      backtrack(res, new ArrayList<Integer>(), new HashSet<Integer>(), nums);
      return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> buffer, Set<Integer> set, int [] nums){
      if (buffer.size() == nums.length) {
        res.add(new ArrayList<Integer>(buffer));
        return;
      } else {
          for (int i = 0; i < nums.length; i++) {
              if (!set.contains(nums[i])) {
                  set.add(nums[i]);
                  buffer.add(nums[i]);
                  backtrack(res, buffer, set, nums);
                  set.remove(nums[i]);
                  buffer.remove(buffer.size() - 1);
              }
          }
      }
  }
}
