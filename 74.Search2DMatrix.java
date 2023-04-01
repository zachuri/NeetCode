class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    // initialize total row and column
    int r = matrix.length;
    int c = matrix[0].length;

    // initialize beg and end
    int beg = 0;
    int end = r * c - 1; 

    while (beg <= end) {
      // initalize mid 
      int mid = (beg + end) / 2;

      // initalize midValue where it gets mid of
      //  row and column 
      //  row calculated of mid / column
      //  column calculated of mid % column 
      //    when 2d array is flat -> it gets the middle
      int midValue = matrix[mid / c][mid % c];

      if (midValue == target) {
        return true;
      } 
      else if (target < midValue) {
        end = mid - 1;
      }
      else {
        beg = mid + 1;
      }
    }

    return false;
  }
}