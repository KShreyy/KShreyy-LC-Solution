class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] t=new int[n][n+1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

       
        return helper(0,-1,nums,t);
        
    }
    public int helper(int i,int prev,int[] nums,int[][] t){
      
        if(i==nums.length){
            return 0;
        }
        if(t[i][prev+1]!=-1){
            return t[i][prev+1];
        }
        int not_take=helper(i+1,prev,nums,t);
        int take=0;
        int max_len=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+helper(i+1,i,nums,t);
            
             }
             max_len=Math.max(take,not_take);
        
        return t[i][prev+1]=max_len;
        
        }
    }

/*class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return helper(0,-1,nums);
        
    }
    public int helper(int i,int prev,int[] nums){
        int max_len=0;
        for(int k=i;k<=nums.length-1;k++){
            if(prev==-1){
                max_len=Math.max(1+helper(i+1,i,nums),helper(i+1,prev,nums));
            }
            else{ 
                if(nums[k]>nums[prev]){
                max_len=Math.max(1+helper(i+1,k,nums),helper(i+1,prev,nums));}
                else{
                    max_len=Math.max(max_len,helper(i+1,prev,nums));
                }
            }
        }
        return max_len;
    }}
    */


