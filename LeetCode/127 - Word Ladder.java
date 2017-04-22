public class Solution {
    
    public class GraphNode
	{
		public String word;
		public ArrayList<GraphNode> adj;
		
		public GraphNode(String word)
		{
			this.word = word;
			adj = new ArrayList<>();
		}
	}
	

    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        wordList.add(beginWord);   
        GraphNode start = buildGraph(wordList,beginWord);
        
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> flags = new HashSet<>();
        
        map.put(start.word, 1);
        flags.add(start.word);
        
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty())
        {
            GraphNode current = queue.poll();
            if(current.word.equals(endWord))
                return map.get(current.word);
                
            for(int i = 0; i < current.adj.size(); i++)
            {
                GraphNode adj = current.adj.get(i);
                if(!flags.contains(adj.word))
                {
                    map.put(adj.word, map.get(current.word) + 1);
                    flags.add(adj.word);
                    queue.add(adj);
                }
            }
        }
        
        return 0;
    }
    
    private GraphNode buildGraph(List<String> dictionary, String beginWord)
	{
		GraphNode[] nodes = new GraphNode[dictionary.size()];
		
		for(int i = 0; i < dictionary.size(); i++)
            nodes[i] = new GraphNode(dictionary.get(i));    
		
	    for(int i = 0; i < nodes.length; i++)
	    {
	        GraphNode current = nodes[i];
	        for(int j = 0; j < nodes.length; j++)
		    {
				if(i == j)
					continue;
				String temp = nodes[j].word;
				
				 if(compareWords(current.word, temp))
					 current.adj.add(nodes[j]);
	    	}
	    }
	    
		return nodes[nodes.length - 1];
	}
	
	private boolean compareWords(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		int countDifferences = 0;
		
		for(int i = 0; i < a.length() && countDifferences <= 1; i++)
		{
			if(a.charAt(i) != b.charAt(i))
				countDifferences++;
		}
		
		return (countDifferences == 1);
	}
    
}