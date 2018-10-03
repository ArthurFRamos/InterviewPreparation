public class Solution {
    public bool LemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        
        foreach(var bill in bills)
        {
            if(bill == 5)
                fives++;
            
            else if(bill == 10)
            {
                tens++;
                fives--;
                if(fives < 0)
                    return false;
            }
            else
            {
                if(tens == 0)
                    fives = fives - 3;
                else
                {
                    fives--;
                    tens--;
                }

                if(fives < 0 || tens < 0)
                    return false;
            }
            
            Console.WriteLine(">>> " + bill);
            Console.WriteLine(fives);
            Console.WriteLine(tens);
        }
        
        return true;
    }
}