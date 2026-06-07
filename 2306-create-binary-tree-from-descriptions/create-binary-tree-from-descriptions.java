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
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        int n = descriptions.length;
        
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> root = new HashSet<>();

        for(int i = 0; i < n; i++){

            int[] node = descriptions[i];
            int parent = node[0];
            int child = node[1];
            int child_pos = node[2];

            if(root.contains(child)){
                root.remove(child);
            }

            if(map.containsKey(parent)){

                if(map.containsKey(child)){
                    if(child_pos == 1){
                        map.get(parent).left = map.get(child);
                    }
                    else{
                        map.get(parent).right = map.get(child);
                    }
                    
                }
                else{
                    TreeNode chd = new TreeNode(child);

                    if(child_pos == 1){
                        map.get(parent).left = chd;
                    }
                    else{
                        map.get(parent).right = chd;
                    }

                    map.put(child, chd);
                }
            }
            else{
                TreeNode Node = new TreeNode(parent);

                if(map.containsKey(child)){

                    if(child_pos == 1){
                        Node.left = map.get(child);
                    }
                    else{
                        Node.right = map.get(child);
                    }

                }
                else{
                    TreeNode chd = new TreeNode(child);

                    if(child_pos == 1){
                        Node.left = chd;
                    }
                    else{
                        Node.right = chd;
                    }
                    map.put(child, chd);
                    
                }

                map.put(parent, Node);
                root.add(parent);

            }
        }

        int val = 0;

        for(int i : root){
            val = i;
        }

        TreeNode Root = map.get(val);

        return Root;
    }
}