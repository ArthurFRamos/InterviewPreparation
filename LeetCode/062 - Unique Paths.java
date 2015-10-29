public class Solution {
    public int[] plusOne(int[] digits) {
        int carryOver = 0;
        if(digits == null)
            return null;
        for(int i = digits.length -1; i >= 0; i--)
        {
            if(i == digits.length - 1)
            {
                digits[i] += 1;
                carryOver = digits[i]/10;
                digits[i] %= 10;
            }
            else
            {
                if(carryOver > 0)
                {
                      digits[i] += 1;
                    carryOver = digits[i]/10;
                    digits[i] %= 10;
                }
            }
        }
        
        int[] newDigits;
        
        if(carryOver > 0)
        {
            newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int i = 0; i < digits.length; i++)
                newDigits[i+1] = digits[i];
        }
        else
            newDigits = digits;
        
        return newDigits;
    }
}