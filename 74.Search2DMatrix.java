class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    // get the m and n of the matrix
    int m = matrix.length;
    int n = matrix[0].length;     

    // declare beg
    int beg = 0;
    int end = m * n - 1;

    while (beg <= end) {
      int mid = (beg + end) / 2;

      // calculating the value of the 1d array
      // first getting the middle row
      // then middle of column with modulous -> using remainder 
      int midValue = matrix[mid / n][mid % n];

      if (midValue == target) {
        return true;
      }
      else if (midValue < target) {
        beg = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    
    return false;
  }
}