/*
class Solution {
    private boolean subsetsum(int[] nums,int sum){
        n=nums.length;
        int[][] t=new int[n+1][sum+1];
        for(int i=0;i<nums+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0){
                    t[i][j]=flase;
                if(i==0){
                    t[i][j]=true;
                }
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for()
        }
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0){
            return false;

        }
        else if{
            return subsetsum(nums,sum/2);
        }
        }
        
    }
}
class Solution {
    private boolean subsetsum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        // Initialize the DP table
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true; // sum = 0 can always be achieved with 0 elements
        }

        for (int j = 1; j < sum + 1; j++) {
            t[0][j] = false; // if we have no items, we can't achieve positive sum
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Check if there's a subset with sum equal to sum/2
        return subsetsum(nums, sum / 2);
    }
}*/
class Solution {
    private boolean subsetsum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        // Initialize the DP table
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true; // sum = 0 can always be achieved with 0 elements
        }

        for (int j = 1; j < sum + 1; j++) {
            t[0][j] = false; // if we have no items, we can't achieve positive sum
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Check if there's a subset with sum equal to sum/2
        return subsetsum(nums, sum / 2);
    }
}
