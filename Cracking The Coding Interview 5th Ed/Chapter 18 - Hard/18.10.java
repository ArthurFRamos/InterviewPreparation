public class Solution {
    
    public class GraphNode
	{
		public String word;
		public ArrayList<GraphNode> adj;
		public ArrayList<List<String>> paths;
		
		public GraphNode(String word)
		{
			this.word = word;
			adj = new ArrayList<>();
		    paths = new ArrayList<>();
		}
	}
	

    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
        wordList.add(beginWord);   
        GraphNode start = buildGraph(wordList,beginWord);
        
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> flags = new HashSet<>();
        
        map.put(start.word, 1);

        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(start);
        
        List<List<String>> paths = new ArrayList<List<String>>();
        
        while(!queue.isEmpty())
        {
            GraphNode current = queue.poll();
            if(current.word.equals(endWord))
            {
                paths = current.paths;
                return paths;
                
            }
            for(int i = 0; i < current.adj.size(); i++)
            {
                GraphNode adj = current.adj.get(i);
                int currentValue = map.get(current.word);
                
                if(!map.containsKey(adj.word))
                    map.put(adj.word, currentValue + 1);
                
                int value = map.get(adj.word);
                
                if(value > currentValue)
                {
                   if(!flags.contains(adj.word))
                   {
                        queue.add(adj);
                        flags.add(adj.word);
                   }
                    for(int j = 0; j < current.paths.size(); j++)
                    {
                        ArrayList<String> newPath = new ArrayList<>();
                        
                        for(int k = 0; k < current.paths.get(j).size(); k++)
                            newPath.add(current.paths.get(j).get(k));
                        newPath.add(adj.word);
                        adj.paths.add(newPath);
     
                    }
                }
            }
        }
        return paths;
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
	    
	    ArrayList<String> path = new ArrayList<>();
	    path.add(beginWord);
	    nodes[nodes.length -1].paths.add(path);
	    
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
