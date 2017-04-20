public class Solution {
    
    public class GraphNode
    {
        public int val;
        public ArrayList<GraphNode> adj;
        
        public GraphNode(int val)
        {
            this.val = val;
            this.adj = new ArrayList<>();
        }
    }
    
    public HashSet<Integer> map = new HashSet<>();
    
    public int findCircleNum(int[][] M) {
        ArrayList<GraphNode> graphs = new ArrayList<>();
        int answer = 0;
        
        for(int i = 0; i < M.length; i++)
        {
            graphs.add(new GraphNode(i));
        }
        for(int i = 0; i < M.length; i++)
        {
            GraphNode current = graphs.get(i);
            
            for(int j = 0; j < M[0].length; j++)
            {
                if(j == i)
                    continue;
                if(M[i][j] == 1)
                {
                    GraphNode temp = graphs.get(j);
                    current.adj.add(temp);
                }
            }
        }
        
        for(int i = 0; i < M.length; i++)
        {
            GraphNode current = graphs.get(i);
            LinkedList<GraphNode> queue = new LinkedList<>();
            
            if(!map.contains(current.val))
            {
                queue.add(current);
                map.add(current.val);
                answer++;
            }    
            while(!queue.isEmpty())
            {
                GraphNode temp = queue.poll();
                
                for(int  j = 0; j < temp.adj.size(); j++)
                {
                    if(!map.contains(temp.adj.get(j).val))
                    {
                        queue.add(temp.adj.get(j));
                        map.add(temp.adj.get(j).val);
                    }
                }
            }
        }
        
        return answer;
    }
}