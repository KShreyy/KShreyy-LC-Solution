class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = arr[n + 1] = 1;
        return helper(1, n, arr, new int[n + 2][n + 2]);
    }

    // Add memoization to avoid recomputation
    public int helper(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1]
                        + helper(i, k - 1, arr, dp)
                        + helper(k + 1, j, arr, dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        dp[i][j] = maxCoins;
        return maxCoins;
    }
}

/*
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        int[]
        arr[0]=1;
        arr[n+1]=1;
        return helper(1,n,arr);
    }
    public int helper(int i,int j,int[] arr){
        if(i>j){return 0;}
        int max=0;
        for(int k=i;k<=j;k++){
            int cost=arr[i-1]*arr[k]*arr[j+1]+helper(i,k-1,arr)+helper(k+1,j,arr);
            max=Math.max(cost,max);
        }
        return max;
    }
}
*/