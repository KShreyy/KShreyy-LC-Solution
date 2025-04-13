/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        q.add(root);
       boolean l2r=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                List<Integer> row=new ArrayList<>();
                if(l2r==true){
                    int index=0;
                    row.add(node.data);
                    
                    if (node.left != null) {
                        q.add(node.left);
                }
                    if (node.right != null) {
                        q.add(node.right);
                }
                if(l2r==false){
                    int index=1;
                    row.add(node.data);
                    
                    if (node.left != null) {
                        q.add(node.left);
                }
                    if (node.right != null) {
                        q.add(node.right);
                }

            }
            l2r=!l2r;
            result.add(index,row);


        }
        
    }
}
}
}
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean l2r = true; // left to right

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> row = new LinkedList<>(); // Use LinkedList for efficient head insertion

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (l2r) {
                    row.addLast(node.val);  // normal order
                } else {
                    row.addFirst(node.val); // reverse order
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(row);
            l2r = !l2r; // flip the direction
        }

        return result;
    }
}
