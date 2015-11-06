class TrieNode {
    // Initialize your data structure here.
    
    public TrieNode[] nodes;
    public boolean isWord;
    
    public TrieNode() {
        nodes = new TrieNode[26]; 
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++)
        {
            int pos = word.charAt(i) - 'a';
            
            if(current.nodes[pos] == null)
                current.nodes[pos] = new TrieNode();
            
            current = current.nodes[pos];
        }
        
        current.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++)
        {
            int pos = word.charAt(i) - 'a';
            
            if(current.nodes[pos] == null)
                return false;
            current = current.nodes[pos];
        }
        
        return current.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        
        TrieNode current = root;
        
        for(int i = 0; i < prefix.length(); i++)
        {
            int pos = prefix.charAt(i) - 'a';
            
            if(current.nodes[pos] == null)
                return false;
            current = current.nodes[pos];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");