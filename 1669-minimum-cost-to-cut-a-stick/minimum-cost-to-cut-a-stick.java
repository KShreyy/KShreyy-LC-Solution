import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        
        int[] newCuts = new int[m + 2];
        int[][] t=new int[m+1][m+1];
        // Add 0 and n as the start and end
        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        
        Arrays.sort(newCuts);

        return helper(1, m, newCuts,t);
    }

    private int helper(int i, int j, int[] cuts,int[][] t) {
        // Base case: no cuts to make
        
        if (i > j) {
            return 0;
        }
        if(t[i][j]!=0){
            return t[i][j];
        }
        int minCost = Integer.MAX_VALUE;

        // Try every possible cut between i and j
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1]; // Current stick length
            int left = helper(i, k - 1, cuts,t);    // Cost of left sub-stick
            int right = helper(k + 1, j, cuts,t);   // Cost of right sub-stick
            minCost = Math.min(minCost, cost + left + right);
        }

        return t[i][j]=minCost;
    }
}

/*class Solution {

    public int minCost(int n, int[] cuts) {
        int[] new_cuts=changed_cuts(n,cuts);
        int i=new_cuts[i];
        int j=new_cuts[cuts.length];
        return helper(int i,int j,int[] new_cuts)
    }
    private int helper(int i,int j,int[] arr){
        if(i>=j){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=j;k++){
            cost=new_cuts[j+1]-new_cuts[i-1]+helper(i,k-1,arr)+helper(k+1,j,arr);
            min=Math.min(min,cost);
        }
        return min;
    }
*/

