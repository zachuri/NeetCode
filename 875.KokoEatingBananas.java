import java.util.Arrays;

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    long beg = 1;
    long end = Arrays.stream(piles).max().getAsInt() ;   

    while (beg <= end) {
      // prevents integer overflow for big numbers
      // E.g. 
      long mid = beg + (end - beg) / 2;

      // Calculate total hours required at current k
      long totalHours = 0;

      // total koko eats per hour -> total to eat all bananas 
      for (int pile : piles) {
        totalHours += (long) Math.ceil((double) pile / mid);
      }

      // Update search bounds based on total hours
      if (totalHours <= h) {
        end = mid - 1;
      }
      else {
        beg = mid + 1;
      }
    }

    return (int) beg;
  }
}