import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	private final String mask = "abcdefghijklmnopqrstuvwxyz";
	private HashMap<String,Character> map;
	private String convert;
	private HashSet<String> flags;
	
	public Solution(int convert)
	{
		
		this.convert = Integer.toString(convert);
		map = new HashMap<>();
		flags = new HashSet<>();
		
		for(int i = 0; i < mask.length(); i++)
			map.put(Integer.toString(i),mask.charAt(i));
	}
	
	
	private void convert(int position, String current)
	{
		if(position >= convert.length())
		{
			if(!flags.contains(current))
				flags.add(current);
			return;
		}
		
		Character temp = map.get(Character.toString(convert.charAt(position)));
		convert(position + 1, current + temp);
		
		if(position == convert.length() - 1)
			return;
		
		temp = map.get(convert.substring(position, position + 2));
		if(temp == null)
			return;
		convert(position + 2, current + temp);
	}
	
	public int count()
	{
		convert(0,"");
		return flags.size();
	}
	
	public static void main(String[] args)
	{
		Solution s = new Solution(12258);
		System.out.println(s.count());
	}
}
