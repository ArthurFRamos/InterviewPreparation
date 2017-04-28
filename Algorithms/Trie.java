import java.util.HashMap;

public class Trie {
	
	public class TrieNode
	{
		public Character key;
		public boolean isWord;
		public HashMap<Character,TrieNode> adj;
		
		public TrieNode(Character key, boolean isWord)
		{
			this.key = key;
			this.isWord = isWord;
			adj = new HashMap<>();
		}
	}
	
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode(null,false);
	}
	
	public void add(String word)
	{
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			Character temp = word.charAt(i);
			TrieNode next = null;
			if(!current.adj.containsKey(temp))
			{
				next = new TrieNode(temp, false);
				current.adj.put(temp, next);
				
			}
			else
				next = current.adj.get(temp);
			
			current = next;
		}
		
		current.isWord = true;
	}
	
	public boolean search(String word)
	{
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			Character temp = word.charAt(i);
			if(!current.adj.containsKey(temp))
				return false;
			current = current.adj.get(temp);
		}
		
		return current.isWord;
	}
	
	public void remove(String word)
	{
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			Character temp = word.charAt(i);
			if(!current.adj.containsKey(temp))
				return;
			current = current.adj.get(temp);
		}
		
		current.isWord = false;
	}
	
	public static void main (String[] args)
	{
		Trie t = new Trie();
		t.add("Lais");
		t.add("Arthur");
		System.out.println(t.search("Lais"));
		t.remove("Arthur");
		System.out.println(t.search("Arthur"));
	}
}
