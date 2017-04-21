public class Solution {
    public String reverseStr(String s, int k) {
        
        int index = 0;
        while(index < s.length())
        {
            System.out.println(index);
            s = reverse(s,index,k);
            index += 2*k;
        }
        
        return s;
    }
    
    
    private String reverse(String s, int index, int k)
    {
        char[] letters = s.toCharArray();
        if(index + k > letters.length)
            k = letters.length - index;
        
        for(int i = 0; i < k/2; i++)
        {
            char temp = letters[index + i];  
            letters[index + i] = letters[index + k - 1 - i];
            letters[index + k - 1 - i] = temp;
        }
        
        return new String(letters);
    }
    
}