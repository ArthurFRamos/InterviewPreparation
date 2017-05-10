public class Solution {
    public String[] findWords(String[] words) {
        String[] rows = new String[3]; 
        rows[0] = "qwertyuiop";
        rows[1] = "asdfghjkl";
        rows[2] = "zxcvbnm";
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < rows.length; i++)
            for(int j = 0; j < rows[i].length(); j++)
                map.put(rows[i].charAt(j), i);
        
        ArrayList<String> findWords = new ArrayList<>();
        
        int currentRow = -1;
        
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].length() == 0)
            {
                findWords.add(words[i]);
                continue;   
            }
            
            currentRow = map.get(Character.toLowerCase(words[i].charAt(0)));
            boolean addWord = true;
            
            for(int j = 1; j < words[i].length(); j++)
            {
                if(map.get(Character.toLowerCase(words[i].charAt(j))) != currentRow)
                {
                    addWord = false;
                    break;
                }
            }
            
            if(addWord)
                findWords.add(words[i]);
        }
        
        String[] answer = new String[findWords.size()];
        
        for(int i = 0; i < findWords.size(); i++)
            answer[i] = findWords.get(i);
        
        return answer;
    }
}