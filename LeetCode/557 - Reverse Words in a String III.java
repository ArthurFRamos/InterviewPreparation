public class Solution {
    public String reverseWords(String s) {
        StringBuffer word = new StringBuffer();
        StringBuffer sentence = new StringBuffer();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ')
            {
                if(!word.toString().equals(""))
                {
                    sentence.append(word.reverse());
                    word = new StringBuffer();   
                }
            
                sentence.append(' ');
                
            }
            else
                word.append(s.charAt(i));
        }
        
        sentence.append(word.reverse());
        
        return sentence.toString();
    }
}