class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int max1 = helper(nums, 0, n - 2); // exclude last house
        int max2 = helper(nums, 1, n - 1); // exclude first house
        return Math.max(max1, max2);
    }

    public int helper(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return nums[start];

        int[] t = new int[len];
        t[0] = nums[start];
        t[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len; i++) {
            int take = nums[start + i] + t[i - 2];
            int not_take = t[i - 1];
            t[i] = Math.max(take, not_take);
        }

        return t[len - 1];
    }
}
