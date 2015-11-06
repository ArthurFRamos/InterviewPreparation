public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        
        for(String i : strs)
        {
            char[] temp = i.toCharArray();
            Arrays.sort(temp);
            String tempString = new String(temp);
            
            if(!map.containsKey(tempString))
                map.put(tempString, new ArrayList<String>());
            
            ArrayList<String> current = map.get(tempString);
            current.add(i);
        }
        
        for(String i : map.keySet())
        {
            ArrayList<String> current = map.get(i);
            Collections.sort(current);
            
            list.add(current);
            
        }
        
        return list;
    }
    
    
}