/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> data = new ArrayList<>();
        
        if(root == null)
            return "";
        
        data.add(root.val);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();
            if(current == null)
                continue;
            if(current.left != null)
            {
                data.add(current.left.val);
                queue.add(current.left);   
            }
            else
                data.add(null);
                
            if(current.right != null)
            {
                data.add(current.right.val);
                queue.add(current.right);
            }
            else
                data.add(null);
        }
    
        StringBuffer buffer = new StringBuffer("");
        
        for(int i = 0; i < data.size(); i++)
        {
            Integer current = data.get(i);
            if(current == null)
                buffer.append("null,");
            else
            {
                buffer.append(Integer.toString(current));
                buffer.append(",");
            }
        }
        
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuffer buffer = new StringBuffer();
        ArrayList<Integer> nodes = new ArrayList<>();
        
        for(int i = 0; i < data.length(); i++)
        {
            char temp = data.charAt(i);
            if(temp == ',' ||  i == data.length() - 1)
            {
                if(temp != ',')
                    buffer.append(temp);
                
                if(buffer.toString().equals("null"))
                    nodes.add(null);
                else
                    nodes.add(Integer.parseInt(buffer.toString()));
                
                buffer = new StringBuffer();
            }
            else
                buffer.append(temp);
        }
        
        if(nodes.size() == 0)
            return null;
            
        int index = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = getNode(nodes,0);
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();
            TreeNode temp = getNode(nodes,index);
            index++;
            
            if(temp != null)
                queue.add(temp);
            current.left = temp;
            
            temp = getNode(nodes,index);
            index++;
            
            if(temp != null)
                queue.add(temp);
            current.right = temp;
        }
        
        return root;
    }
    
    private TreeNode getNode(ArrayList<Integer> nodes, int index)
    {
        Integer temp = nodes.get(index);
        if(temp == null)
            return null;
        else
            return new TreeNode(temp);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));