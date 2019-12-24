/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> leveResult = new ArrayList();
            int size = queue.size();
            for(int i=0;i<size;++i){
                TreeNode node = queue.poll();
                leveResult.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.addFirst(leveResult);
        }
        return result;
    }
    
    class Solution 1{
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> temp = new LinkedList();
            traLevel(temp,0,root);
            LinkedList<List<Integer>> result = new LinkedList();
            for(int i=temp.size()-1;i>=0;i--){
                result.add(temp.get(i));
            }
            return result;
        }

        void traLevel(LinkedList<List<Integer>> result,int level,TreeNode node){
            if(node==null)
                return;
            if(result.size() == level){
                List<Integer> list = new LinkedList<>();
                list.add(node.val);
                result.add(list);
            }else{
                result.get(level).add(node.val);
            }
            traLevel(result,level+1,node.left);
            traLevel(result,level+1,node.right);
        }
    }
}
