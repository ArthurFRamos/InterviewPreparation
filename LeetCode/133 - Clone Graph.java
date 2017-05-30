/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return node;
            
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        HashSet<Integer> flags = new HashSet<>();
        
        UndirectedGraphNode firstNode = new UndirectedGraphNode(node.label);
        map.put(node.label, firstNode);
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        
        queue.add(node);
        flags.add(node.label);
        
        while(!queue.isEmpty())
        {
            UndirectedGraphNode current = queue.poll();
            UndirectedGraphNode copy = map.get(current.label);
            
            for(int i = 0; i < current.neighbors.size(); i++)
            {
                UndirectedGraphNode temp = current.neighbors.get(i);
                if(!map.containsKey(temp.label))
                    map.put(temp.label, new UndirectedGraphNode(temp.label));
                copy.neighbors.add(map.get(temp.label));
                if(!flags.contains(temp.label))
                {
                    flags.add(temp.label);
                    queue.add(temp);
                }
            }
        }
        
        return firstNode;
        
        
    }
}