
class Solution {
    public int maxProfit(int[] prices,int fee) {
        int[][] t=new int[prices.length+1][2];
        for(int i=0;i<=1;i++){
            for(int j=0;j<prices.length;j++){
                
        
                    t[j][i]=-1;

                
            }
        }
        
        return helper(0,1,prices,t,fee);
    }
    public int helper(int ind,int buy,int[] prices,int[][] t,int fee){
        //base case
        
        int max_profit=0;
      
        if(ind==prices.length){
            return 0;
            
        }
    
        
        if(t[ind][buy] !=-1){
            return t[ind][buy];
        }
        if(buy==1){
            max_profit=Math.max(-prices[ind]+helper(ind+1,0,prices,t,fee),0+helper(ind+1,1,prices,t,fee));
        }
        else{
            max_profit=Math.max(prices[ind]+helper(ind+1,1,prices,t,fee)-fee,0+helper(ind+1,0,prices,t,fee));
        }
        return t[ind][buy]=max_profit;
    }
}