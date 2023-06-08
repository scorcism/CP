public class LeetCode {

    public static void main(String[] args) {

    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countNegatives2(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            // do bs in each row
            int low = 0;
            int high = row.length - 1;

            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                // get the first index of <0 ele o the rest of that will be easy to get as the
                // 1st index to n will alwasy have -v1
                if (row[mid] < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            count += (grid[0].length - low);

        }

        return count;
    }
}
