import java.util.ArrayList;
import java.util.HashSet;

public class PermutationString {
	private String generator;
	private char[] letters;
	private HashSet<Integer> flag;
	private ArrayList<String> permutations;
	
	public PermutationString(String generator)
	{
		this.generator = generator;
		this.letters = generator.toCharArray();
		this.flag = new HashSet<>();
		this.permutations = new ArrayList<>();
	}
	
	public void permute()
	{
		permute(generator.length(), "");
	}
	private void permute(int left, String current)
	{
		if(left == 0)
		{
			permutations.add(current);
			return;
		}
		for(int i = 0; i < letters.length; i++)
		{
			if(!flag.contains(i))
			{
				flag.add(i);
				current = current + generator.charAt(i);
				permute(left - 1, current);
				current = current.substring(0,current.length() -1);
				flag.remove(i);
			}
		}
	}
	
	public void printPermutations()
	{
		for(int i = 0; i < permutations.size(); i++)
			System.out.println(permutations.get(i));
	}
	
	public static void main(String[] args)
	{
		PermutationString s = new PermutationString("Wrong!");
		
		s.permute();
		
		s.printPermutations();
		
	}
}
