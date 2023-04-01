import java.util.Arrays;

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    // Binary search for minimum k
    // Set the left and right bounds of the search space
    long left = 1;
    long right = Arrays.stream(piles).max().getAsInt();

    // Continue searching while the left bound is less than or equal to the right bound
    while (left <= right) {
        // Calculate the middle point of the search space
        // Prevents for integer overflow
        long mid = left + (right - left) / 2;

        // Calculate the total number of hours required to eat all bananas at the current eating speed
        long totalHours = 0;
        
        for (int pile : piles) {
            // Add the number of hours required to eat the current pile of bananas
            // Note that we use the ceil function to round up any partial hours
            totalHours += (long) Math.ceil((double) pile / mid);
        }

        // Check if the total number of hours is less than or equal to the available time
        // If so, we can try a slower eating speed to see if it's still possible to eat all the bananas in time
        if (totalHours <= h) {
            right = mid - 1; // Move the right bound of the search space to try slower eating speeds
        } else {
            left = mid + 1; // Move the left bound of the search space to try faster eating speeds
        }
    }

    // Return the minimum eating speed (i.e. the left bound of the search space)
    return (int) left;
  }

}