public class Solution {
    public string LongestWord(string[] words) {
        HashSet<string> flags = new HashSet<string>();
        
        foreach(var word in words)
            flags.Add(word);
        
        var max = -1;
        String largest = String.Empty;
      
        foreach(var word in words)
        {
            Boolean toAdd = true;
            if(word.Length < max )
                continue;
            if(word.Length == max && word.CompareTo(largest) > 0)
                continue;
            
            for(int i = 1; i <= word.Length; i++)
            {
                if(!flags.Contains(word.Substring(0,i)))
                {
                    toAdd = false;
                    break;
                }
                
            }
            
            if(toAdd)
            {
                max = word.Length;
                largest = word;
            }

        }
        
        return largest;
        
    }
}