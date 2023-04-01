class Solution {
  public int search(int[] nums, int target) {
    int beg = 0, end = nums.length - 1;

    while (beg <= end) {
      int mid = (beg + end) / 2;

      if (nums[mid] == target) {
        return mid; 
      }
      else if (target < nums[mid]) {
        end = target - 1;
      }
      else {
        beg = target + 1; 
      }
    }

    return -1;

  }
}