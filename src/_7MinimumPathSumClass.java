import java.util.Arrays;

public class _7MinimumPathSumClass {
    public static void main(String[] args) {

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        ByMemoization byMemoization = new ByMemoization();
        ByTabulation byTabulation = new ByTabulation();

        int r1 = byMemoization.minPathSum(grid);
        int r2 = byTabulation.minPathSum(grid);


        System.out.println("r1---------"+r1);
        System.out.println("r2-------"+r2);


    }


    public static class ByMemoization{
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int result = solve(grid,dp,0,0,m-1,n-1);

            return result;

        }

        public int solve(int[][] grid ,int[][] dp,int row, int col, int m , int n){

            if(row == m && col == n){
                return grid[row][col];
            }

            if(row>m || col>n){
                return Integer.MAX_VALUE;
            }

            if(dp[row][col]!=-1){
                return dp[row][col];
            }


            int right = solve(grid,dp,row+1,col,m,n);
            int down = solve(grid,dp,row,col+1,m,n);

            int min = Math.min(right,down);

            return dp[row][col] = min+grid[row][col];


        }
    }
    public static class ByTabulation{
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];

            dp[0][0] = grid[0][0];

            for( int row = 1;row<m;row++){
                dp[row][0] = grid[row][0]+dp[row-1][0];
            }
            for( int col = 1;col<n;col++){
                dp[0][col] = grid[0][col]+dp[0][col-1];
            }

            for( int row=1;row<m;row++){
                for(int col = 1;col<n;col++){
                    dp[row][col] = grid[row][col]+Math.min(dp[row-1][col],dp[row][col-1]);
                }
            }
            return dp[m-1][n-1];

        }

    }
}
