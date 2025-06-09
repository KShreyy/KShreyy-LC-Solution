class Solution {
    public int maxProfit(int[] prices) {
        int[][] t=new int[prices.length+1][2];
        for(int i=0;i<=1;i++){
            for(int j=0;j<prices.length;j++){
                t[j][i]=-1;
            }
        }
        return helper(0,1,prices,t);
    }
    public int helper(int ind,int buy,int[] prices,int[][] t){
        //base case
        
        int max_profit=0;
        if(ind==prices.length){
            return 0;
            
        }
        if(t[ind][buy]!=-1){
            return t[ind][buy];
        }
        if(buy==1){
            max_profit=Math.max(-prices[ind]+helper(ind+1,0,prices,t),0+helper(ind+1,1,prices,t));
        }
        else{
            max_profit=Math.max(prices[ind]+helper(ind+1,1,prices,t),0+helper(ind+1,0,prices,t));
        }
        return t[ind][buy]=max_profit;
    }
}
/*
class Solution {
    public int maxProfit(int[] prices) {
        
        return helper(0,1,prices);
    }
    public int helper(int ind,int buy,int[] prices){
        //base case
        int max_profit=0;
        if(ind==prices.length){
            return 0;
        }
        if(buy==1){
            max_profit=Math.max(-prices[ind]+helper(ind+1,0,prices),0+helper(ind+1,1,prices));
        }
        else{
            max_profit=Math.max(prices[ind]+helper(ind+1,1,prices),0+helper(ind+1,0,prices));
        }
        return max_profit;
    }
}*/