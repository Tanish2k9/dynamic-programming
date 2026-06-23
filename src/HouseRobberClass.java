public class HouseRobberClass {
    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};

        ByRecursion byRecursion = new ByRecursion();
        int result1 = byRecursion.rob(nums);
        System.out.println("by recursion--------------------"+result1);

        ByMemoization byMemoization = new ByMemoization();
        int result2 = byMemoization.rob(nums);
        System.out.println("by memoization--------------------"+result2);

        ByTabulation byTabulation = new ByTabulation();
        int result3 = byTabulation.rob(nums);
        System.out.println("by tabulation--------------------"+result3);

        BySpaceOptimized bySpaceOptimized = new BySpaceOptimized();
        int result4 = bySpaceOptimized.rob(nums);
        System.out.println("by space ooptimization---------------------"+result4);

    }

    public static class ByRecursion{
        public int rob(int[] nums) {
            int n = nums.length;
            int result = robHelper(nums,n,0);
            return result;
        }

        public int robHelper(int[] nums, int n , int idx){
            if(idx>=n){
                return 0;
            }

            int take = nums[idx] + robHelper(nums,n,idx+2);
            int skip = robHelper(nums,n,idx+1);

            return Math.max(take,skip);
        }
    }
    public static class ByMemoization{
        public int rob(int[] nums) {

            int n = nums.length;
            Integer[] dp = new Integer[n];
            int result = robHelper(nums,dp,n,0);
            return result;
        }

        public int robHelper(int[] nums,Integer[] dp ,int n , int idx){
            if(idx>=n){
                return 0;
            }

            if(dp[idx]!=null){
                return dp[idx];
            }

            int take = nums[idx] + robHelper(nums,dp,n,idx+2);
            int skip = robHelper(nums,dp,n,idx+1);

            return dp[idx] =Math.max(take,skip);
        }
    }
    public static class ByTabulation{
        public int rob(int[] nums) {
            if(nums.length ==1){
                return nums[0];
            }
            int n = nums.length;
            int[] dp = new int[n];

            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);

            for(int i = 2;i<n;i++){
                int take = nums[i]+ dp[i-2];
                int skip = dp[i-1];
                dp[i]= Math.max(take,skip);
            }

            return dp[n-1];
        }
    }
    public static class BySpaceOptimized{
        public int rob(int[] nums) {
            if(nums.length ==1){
                return nums[0];
            }
            int n = nums.length;
            int[] dp = new int[n];

            int prev1 = nums[0];
            int prev2 = Math.max(nums[0],nums[1]);

            for(int i = 2;i<n;i++){
                int take = nums[i]+ prev1;
                int skip = prev2;
                int current = Math.max(take,skip);
                prev1 = prev2;
                prev2 =current;
            }

            return prev2;
        }
    }
}
