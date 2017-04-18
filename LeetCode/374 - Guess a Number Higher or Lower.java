/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long begin = 1;
        long end = n;
        
        while(begin <= end)
        {
            int mid = (int)((begin + end)/2);
            
            if(guess(mid) == -1)
                end = mid - 1;
            else if(guess(mid) == 1)
                begin = mid + 1;
            else
                return mid;
        }
        
        return -1;
    }
}