class Solution {
    public int climbStairs(int n) {
        int[] t=new int[n];
        for(int i=0;i<n;i++){
            t[i]=-1;
        }
        return helper(0,n,t);
    }
    public int helper(int i,int n,int[] t){
        
        
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(t[i]!=-1){
            return t[i];}
        return t[i]=helper(i+1,n,t) + helper(i+2,n,t);
        
    }
}