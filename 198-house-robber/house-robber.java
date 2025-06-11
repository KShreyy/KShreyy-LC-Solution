class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] t = new int[n];
        t[0] = nums[0];
        t[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int take = nums[i] + t[i - 2];
            int not_take = t[i - 1];
            t[i] = Math.max(take, not_take);
        }

        return t[n - 1];
    }
}


    