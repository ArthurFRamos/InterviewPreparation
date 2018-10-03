/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node(){}
    public Node(int _val,IList<Node> _children) {
        val = _val;
        children = _children;
}
*/


public class Solution {
    
    int max = -1;
    
    public int MaxDepth(Node root) {
        if(root == null)
            return 0;
        
        Traverse(root, 1);
        
        return max;
    }
    
    public void Transverse(Node node, int currentLevel)
    {
        if(currentLevel > max)
            max = currentLevel;
        
        if(node.children != null)
            foreach(var child in node.children)
                Transverse(child, currentLevel + 1);
    }
}