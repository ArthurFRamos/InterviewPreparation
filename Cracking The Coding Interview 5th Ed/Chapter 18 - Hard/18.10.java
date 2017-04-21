import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class TransformWord {
	
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
	
	private HashMap<String,GraphNode> map;
	private ArrayList<String> dictionary;
	private ArrayList<String> finalPath;
	private HashSet<String> flags;
	private int minDepth = Integer.MAX_VALUE;
	
	public TransformWord(ArrayList<String> dic)
	{
		this.dictionary = dic;
		map = new HashMap<>();
		this.buildGraph();
		this.flags = new HashSet<>();
	}
	
	public void path(String a, String b)
	{
		GraphNode current = map.get(a);
		
		if(current == null)
		{
			System.out.println("There is no path starting at " + a);
			return;
		}
		
		
		ArrayList<String> path = new ArrayList<>();
		path.add(current.word);
		flags.add(current.word);
		
		find(current,path, b,0);
		
		if(finalPath == null)
		{
			System.out.println("There is no path ending at " + b);
			return;
		}
		
		for(int i = 0; i < finalPath.size(); i++)
			System.out.println(finalPath.get(i));
	}
	
	private void find(GraphNode current,ArrayList<String> path, String target, int depth)
	{
		flags.add(current.word);
		
		if(current.word.equals(target) && depth < minDepth)
		{
			minDepth = depth;
			finalPath = new ArrayList<>();
			
			for(int i = 0; i < path.size(); i++)
				finalPath.add(path.get(i));
			
			flags.remove(current.word);
			return;
		}
		
		for(int i = 0; i < current.adj.size(); i++)
		{
			GraphNode temp = current.adj.get(i);
			if(!flags.contains(temp.word))
			{
				path.add(temp.word);
				find(temp,path,target, depth + 1);
			}
		}
		flags.remove(current.word);
	}
	
	private void buildGraph()
	{
		GraphNode node = null;
		
		for(int i = 0; i < dictionary.size(); i++)
		{
			String current = dictionary.get(i);
			if(!map.containsKey(current))
			{
				node = new GraphNode(current);
				map.put(current, node);
			}
			else
				node = map.get(current);
			
			for(int j = 0; j < dictionary.size(); j++)
			{
				if(i == j)
					continue;
				String temp = dictionary.get(j);
				 if(compareWords(current, temp))
				 {
					 if(!map.containsKey(temp))
					 {
						 GraphNode toAdd = new GraphNode(temp);
					 	 map.put(temp, toAdd);
					 }
					
					 node.adj.add(map.get(temp));
				 }
			}
		}
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
	
	public static void main(String[] args)
	{
		ArrayList<String> dic = new ArrayList<>();
		dic.add("DAMP");
		dic.add("LAMP");
		dic.add("LIMP");
		dic.add("LIME");
		dic.add("LIKE");
		TransformWord a = new TransformWord(dic);
		a.path("LIME", "DAMP");
	}
}
