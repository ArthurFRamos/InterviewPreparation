public class Solution {
    public String getPermutation(int n, int k) {
		int currentFat;
		int currentPos = 0;
		StringBuffer buffer = new StringBuffer();
		int count = 0;
		String currentString = new String();
		Integer helper = 0;

		HashSet<Integer> map = new HashSet<Integer>();

		while(currentPos != n)
		{
			currentFat = calcFat(n - currentPos - 1);
			int temp;
			
			if(k == 0)
				temp = 0;
			else
			{
				temp = (k-1)/currentFat;
				temp %= (n - currentPos);
			}


			for(int i = 1; i <= n && count <= temp; i++)
			{
				if(!map.contains(i))
				{
					helper = i;
					currentString = helper.toString();
					count++;
				}
			}
			buffer.append(currentString);
			map.add(helper);
			currentPos++;
			count = 0;
		}

		return buffer.toString();
	}

	private int calcFat(int n)
	{
		int result = 1;

		for(int i = 2; i <= n; i++)
			result*= i;

		return result;
	}
}