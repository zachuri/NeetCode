import java.util.Set;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    // Set -> doesn't contain duplicates
    Set<Character> set = new HashSet<>();

    int left = 0;
    int right = 0;
    int n = s.length();

    int maxLen = 0;

    while (right < n) {
      // at current right idx -> check if contains
      if (!set.contains(s.charAt(right))) {

        // add to char to set with right idx
        set.add(s.charAt(right));

        // add maxLen -> maxLen, calculate maxLen of right and left idx 
        maxLen = Math.max(maxLen, right - left + 1);

        right++;
      }
      else {
        // remove character from set with left idx 
        set.remove(s.charAt(left));

        left++;
      }
    } 

    return maxLen;
  }
}