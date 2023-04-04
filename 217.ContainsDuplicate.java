class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> map = new HashSet<>();

    for (int i = 0; i < nums.length; ++i) {
        if (map.contains(nums[i])) {
            return true;
        }
        map.add(nums[i]);
    }

    return false;
  }
}