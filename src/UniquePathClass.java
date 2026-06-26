public class UniquePathClass {
    public static void main(String[] args) {



    }


    public static class ByMemoization{

            public int uniquePaths(int m, int n) {

                Integer[][] dp = new Integer[m][n];
                return path(0,0,m-1,n-1,dp);
            }

            public int path( int row , int col , int m , int n,Integer[][] dp){

                if(row>m || col>n){
                    return 0;
                }
                if(row == m && col == n){
                    return 1;
                }
                if(dp[m][n]!=null){
                    return dp[m][n];
                }

                int rightWays = path(row,col+1,m,n,dp);
                int downWays = path(row+1,col,m,n,dp);
                return dp[m][n]=rightWays+downWays;

            }

    }
    public static class ByRecursion{
        public int uniquePaths(int m, int n) {



            return path(0,0,m-1,n-1);
        }

        public int path( int row , int col , int m , int n){

            if(row>m || col>n){
                return 0;
            }


            if(row == m && col == n){
                return 1;
            }

            int rightWays = path(row,col+1,m,n);
            int downWays = path(row+1,col,m,n);
            return rightWays+downWays;

        }
    }
    public static class ByTabulation{
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int row =0; row<m;row++ ){
                dp[row][0] = 1;
            }

            for(int col =0; col<n;col++ ){
                dp[0][col] = 1;
            }

            for( int row = 1;row<m;row++){
                for(int col = 1;col<n;col++){

                    dp[row][col] = dp[row-1][col]+dp[row][col-1];
                }
            }
            return dp[m-1][n-1];
        }

    }
}
