public class Solution {
    public String convertToTitle(int n) {
        
        String bits = new String();
        StringBuffer buffer = new StringBuffer();

        while(n > 0)
        {
            
            n = n - 1;
            Integer offset = n % 26;
            int letter = offset + 'A';
            bits =  (char)letter + bits;
            n /= 26;
        }
        return bits;
    }
}