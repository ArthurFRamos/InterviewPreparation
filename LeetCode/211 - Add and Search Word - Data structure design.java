public class WordDictionary {

    class TrieNode
    {
        char letter;
        TrieNode[] adj;
        boolean marked;
        
        public TrieNode(letter c)
        {
            letter = c;
            adj = new TrieNode[27];
            marked = false;
        }
    }
    
    class Trie
    {
        TrieNode root;
        
        public Trie()
        {
            root = new TrieNode('\0');
        }
    }
    
    private Trie trie;
    
    public WordDictionary()
    {
        trie = new Trie();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode current = root;
        int currentLetter;
        
        for(int i = 0; i < word.length(); i++)
        {
            currentLetter = (int)word.charAt(i) - (int)'a';
            if(current.adj[i] == null)
            {
                current.adj[i] = new TrieNode(word.charAt(i));
                current.adj[27] =
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");