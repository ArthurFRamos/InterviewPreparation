public class Solution {
    
    private boolean hasZeroOrOne = false;
    private ArrayList<String> combinations = new ArrayList<>();
    private HashMap<Character,String> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wyxz");
        
        buildWords(digits, 0, new StringBuffer(""));
        
        if(hasZeroOrOne)
            return new ArrayList<String>();
        
        return combinations;
    }
    
    private void buildWords(String digits, int index, StringBuffer buffer)
    {
        if(index == digits.length())
            return;
            
        if(digits.charAt(index) == '0' || digits.charAt(index) == '1')
        {
            hasZeroOrOne = true;
            return;
        }
        
        String current = map.get(digits.charAt(index));
        
        for(int i = 0; i < current.length(); i++)
        {
            buffer.append(current.charAt(i));
            
            if(buffer.length() == digits.length())
                combinations.add(buffer.toString());
            
            StringBuffer helper = new StringBuffer(buffer.toString());
        
            buildWords(digits, index + 1, helper);
            
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
