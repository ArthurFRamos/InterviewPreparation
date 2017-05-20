public class Solution {
    
    public class TrieNode
    {
        public HashMap<Character, TrieNode> adj;
        public boolean isWord;
        
        public TrieNode()
        {
            adj = new HashMap<>();
            isWord = false;
        }
    }
    
    public class Trie
    {
        public TrieNode root;
        
        public Trie()
        {
            root = new TrieNode();
        }
        
        public void add (String word)
        {
            TrieNode current = root;
            
            for(int i = 0; i < word.length(); i++)
            {
                char temp = word.charAt(i);
                
                if(!current.adj.containsKey(temp))
                    current.adj.put(temp, new TrieNode());
        
                current = current.adj.get(temp);
            }
            
            current.isWord = true;
        }
    }
    
    private boolean[][] flags;
    private HashSet<String> addedWords = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        ArrayList<String> result = new ArrayList<>();
        
        if(words == null)
            return result;
            
        flags = new boolean[board.length][board[0].length];
        Trie trie = new Trie();
        
        for(int i = 0; i < words.length; i++)
            trie.add(words[i]);
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                search(i,j,new StringBuffer(), trie.root, board,result);
        
        return result;
    }
    
    public void search(int i, int j, StringBuffer buffer, TrieNode current, char[][] board, ArrayList<String> result)
    {
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length)
            return;
        if(flags[i][j])
            return;
        
        if(!current.adj.containsKey(board[i][j]))
            return;
            
        current = current.adj.get(board[i][j]);
        
        buffer.append(board[i][j]);

        if(current.isWord)
        {
            if(!addedWords.contains(buffer.toString()))
            {
                result.add(buffer.toString());
                addedWords.add(buffer.toString());   
            }
        }
        
        flags[i][j] = true;
        
        search(i-1,j,buffer, current, board, result);
        search(i + 1, j, buffer, current, board, result);
        search(i, j - 1, buffer, current, board, result);
        search(i, j + 1, buffer, current, board, result);
        
        flags[i][j] = false;
        buffer.deleteCharAt(buffer.length() - 1);
    }
}