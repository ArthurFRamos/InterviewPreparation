public class Solution {


	public int countOnes (int number)
	{
		int count = 0;
		
		for(int i = 0; i < 31; i++)
		{
			if((number & 1) != 0)
				count++;
			number >>= 1;
		}
		
		return count;
	}
}
