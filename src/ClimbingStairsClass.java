public class ClimbingStairsClass {
    public static void main(String[] args) {

        ByRecursionOnly recursionOnly = new ByRecursionOnly();

        int recusrionResult = recursionOnly.climbStairs(44);
        System.out.println("------------by recursion --------- " + recusrionResult);

        var byMemoization= new ByMemoization();

        int memoizationResult = byMemoization.climbStairs(44);
        System.out.println("------------by memoization --------- " + memoizationResult);

        var byTabulation= new ByTabulation();

        int tabulationResult = byTabulation.climbStairs(44);
        System.out.println("------------by tabulation --------- " + tabulationResult);


        var bySpaceOptimized= new BySpaceOptimized();

        int spaceResult = bySpaceOptimized.climbStairs(44);
        System.out.println("------------by space optimized --------- " + spaceResult);

    }

    public static class ByRecursionOnly{

        public int climbStairs(int n) {

            if(n==0){
                return 1;
            }
            if(n<0){
                return 0;
            }

            int firstWays = climbStairs(n-1);
            int secondWays =  climbStairs(n-2);

            return firstWays+secondWays;

        }

    }

    public static class ByMemoization{


        public int climbStairs(int n) {


            int[] dp = new int[n+1];

            for (int i = 0;i<=n;i++){
                dp[i] = -1;
            }


            return climbStairsHelper(n,dp);


        }

        public int climbStairsHelper(int n , int[] dp){
            if(n==0 || n==1){
                return 1;
            }
            if(n<0){
                return 0;
            }

            if(dp[n] !=-1){
                return dp[n];
            }

            dp[n-1] = climbStairsHelper(n-1,dp);
            dp[n-2] =  climbStairsHelper(n-2,dp);

            return dp[n-1]+dp[n-2];
        }

    }

    public static class ByTabulation{

        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            for (int i = 0;i<=n;i++){
                dp[i] = -1;
            }
            dp[0] = 1;
            dp[1]= 1;

            for(int i = 2;i<=n;i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n];
        }

    }

    public static class BySpaceOptimized{

        public int climbStairs(int n) {

            int prev1 = 1;
            int prev2= 1;


            for(int i = 2;i<=n;i++){
                int current = prev1 + prev2;
                prev1 = prev2;
                prev2 = current;
            }
            return prev2;
        }

    }








}
