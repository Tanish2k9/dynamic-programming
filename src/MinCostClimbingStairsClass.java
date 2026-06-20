public class MinCostClimbingStairsClass {


    public static void main(String[] args) {


        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        int n = cost.length;

        int i = 0;


        ByRecursion byRecursion = new ByRecursion();
        int result = byRecursion.minCostClimbingStairs(cost);
        System.out.println("by resursion-------- "+result);

        Tabulation tabulation = new Tabulation();
        int reuslt1 = tabulation.solveBYTabulation(cost,n,i);
        System.out.println("by tabulation--------"+reuslt1);

        ByMemoization byMemoization = new ByMemoization();
        int result2 = byMemoization.minCostClimbingStairs(cost);
        System.out.println("by memozation-------- "+result2);

        SpaceOptimized spaceOptimized = new SpaceOptimized();
        int result3 = spaceOptimized.solveBYSpace(cost,n,i);
        System.out.println("by space optimization-------- "+result3);

    }

    static class ByRecursion{
        public int minCostClimbingStairs(int[] cost) {

            int n = cost.length;
            int i = 0;


            int first = solve( cost, n,i);
            int second = solve(cost,n,i+1);

            return Math.min(first,second);


        }

        int solve(int[] cost , int n , int i ){


            if(i>=n){
                return 0 ;
            }


            return cost[i] + Math.min(solve(cost ,n,i+1),solve(cost,n,i+2));



        }
    }

    static class ByMemoization {
        public  int minCostClimbingStairs(int[] cost) {

            int n = cost.length;
            int i = 0;

            Integer[] dp = new Integer[n];


            int first = solve( cost, n,i,dp);
            int second = solve(cost,n,i+1,dp);

            return Math.min(first,second);


        }

        int solve(int[] cost , int n , int i ,Integer[] dp){


            if(i>=n){
                return 0 ;
            }


            if(dp[i] != null){
                return dp[i];
            }

            dp[i] = cost[i] + Math.min(solve(cost ,n,i+1,dp),solve(cost,n,i+2,dp));


            return dp[i];



        }
    }
    static class Tabulation {


         int solveBYTabulation(int[] cost, int n, int k) {

            Integer[] dp = new Integer[n];

            dp[0] = cost[0];
            dp[1] = cost[1];


            for (int i = 2; i < n; i++) {
                dp[2] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }

            int result = Math.min(dp[n - 1], dp[n - 2]);

            return result;

        }
    }

    static class SpaceOptimized {


        int solveBYSpace(int[] cost, int n, int k) {

            Integer[] dp = new Integer[n];

            int prev1 = cost[0];
            int prev2 = cost[1];


            for (int i = 2; i < n; i++) {

                int current = cost[i] + Math.min(prev1,prev2);

                prev1 = prev2;
                prev2 = current;
            }

            int result = Math.min(prev1,prev2);

            return result;

        }
    }

}


