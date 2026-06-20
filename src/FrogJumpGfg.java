import java.util.Arrays;

public class FrogJumpGfg {
    public static void main(String[] args) {

        int heights[] = {30, 20, 50, 10, 40};

        ByRecursion byRecursion = new ByRecursion();
         int result1 =byRecursion.minCost(heights);
        System.out.println("------------------recursion-----"+result1 );



        ByMemoization byMemoization = new ByMemoization();
        int result2 = byMemoization.minCost(heights);
        System.out.println("---------memoization------------"+result2 );

        ByTabulation byTabulation = new ByTabulation();
        int result3 = byTabulation.minCost(heights);
        System.out.println("---------tabualtion------------"+result3 );

        BySpaceOptimized bySpaceOptimized = new BySpaceOptimized();
        int result4 = bySpaceOptimized.minCost(heights);
        System.out.println("---------space optimized------------"+result4 );


    }


    static class ByMemoization{
        int minCost(int[] height) {
            // code here

            int n = height.length;

            int[] dp = new int[n];
            Arrays.fill(dp,-1);

            return minCostHelper(height,n-1,dp);
        }

        int minCostHelper(int[] height,int idx, int[] dp) {
            if(idx == 0 ){
                return 0;
            }

            if(dp[idx]!=-1){
                return dp[idx];
            }

            int firstValue = minCostHelper(height,idx-1,dp) + Math.abs(height[idx] - height[idx-1]);
            int secondValue = Integer.MAX_VALUE;
            if( idx>1){
                secondValue = minCostHelper( height, idx -2,dp) + Math.abs(height[idx] - height[idx-2]);
            }
            return dp[idx] =Math.min(firstValue,secondValue);

        }
    }


    static class ByRecursion{
        int minCost(int[] height) {
            // code here

            int n = height.length;
            return minCostHelper(height,n-1);
        }

        int minCostHelper(int[] height,int idx) {
            if(idx == 0 ){
                return 0;
            }
            int firstValue = minCostHelper(height,idx-1) + Math.abs(height[idx] - height[idx-1]);
            int secondValue = Integer.MAX_VALUE;
            if( idx>1){
                secondValue = minCostHelper( height, idx -2) + Math.abs(height[idx] - height[idx-2]);
            }
            return Math.min(firstValue,secondValue);

        }
    }

    static class ByTabulation{
        int minCost(int[] height) {
            // code here

            int n = height.length;

            int[] dp = new int[n];
            Arrays.fill(dp,-1);

            if(n==1){
                return 0;
            }

            dp[0] = 0;

            for( int i = 1;i<n;i++){

                int firstValue = dp[i-1] + Math.abs(height[i] - height[i-1]);
                int secondValue = Integer.MAX_VALUE;
                if(i>1){
                    secondValue = dp[i-2] + Math.abs(height[i] - height[i-2]);
                }
                dp[i] =Math.min(firstValue,secondValue);
            }
            return dp[n-1];

        }
    }

    static class BySpaceOptimized{
        int minCost(int[] height) {
            // code here
            int n = height.length;

            if(n==1){
                return 0;
            }

            int prev1 = 0;
            int prev2 = 0;

            for( int i = 1;i<n;i++){

                int firstValue = prev2 + Math.abs(height[i] - height[i-1]);
                int secondValue = Integer.MAX_VALUE;
                if(i>1){
                    secondValue = prev1 + Math.abs(height[i] - height[i-2]);
                }
                int current =Math.min(firstValue,secondValue);


                prev1 = prev2;
                prev2 = current;
            }
            return prev2;

        }
    }
}
