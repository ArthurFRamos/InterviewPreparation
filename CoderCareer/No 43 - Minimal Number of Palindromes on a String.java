import java.util.HashMap;

public class MinimalSplits {
	private String word;
	private HashMap<String,Integer> map;
	
	public MinimalSplits(String word)
	{
		this.word = word;
		map = new HashMap<>();
	}
	
	public int split()
	{
		return split(word);
	}
	
	private int split(String current)
	{
		if(map.containsKey(current))
			return map.get(current);
	
		if(current.length() == 1 || checkPalindrome(current))
		{
			map.put(current, 0);
			return 0;
		}
		
		int minimum = Integer.MAX_VALUE;
		
		for(int i = 1; i < current.length(); i++)
		{
			int temp = split(current.substring(0, i)) + split(current.substring(i,current.length())) + 1;
			if(temp < minimum)
				minimum = temp;
		}
		
		map.put(current,minimum);
		return minimum;
	}
	
	private boolean checkPalindrome(String current)
	{
		boolean isPalindrome = true;
		
		for(int i = 0; i < current.length()/2 && isPalindrome; i++)
		{
			if(current.charAt(i) != current.charAt(current.length() - 1 - i))
				isPalindrome = false;
		}
		
		return isPalindrome;
	}
	
	public static void main(String[] args)
	{
		MinimalSplits m = new MinimalSplits("ARandomWordButIsItAWordWhenWeStartConcatanatingLikeThisOrThisCountsAsABadlyFormattedSentence?");
		System.out.println(m.split());
	}
}
