import java.util.Stack;

public class SequenceStacks {
	private int[] push;
	private int[] pop;
	
	public SequenceStacks(int[] push, int[] pop)
	{
		this.push = push;
		this.pop = pop;
	}
	
	private boolean checkSequence()
	{
		int pushIndex = 0;
		int popIndex = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		while(popIndex != pop.length)
		{	
			if(!stack.isEmpty() && (stack.peek() == pop[popIndex]))
			{
				stack.pop();
				popIndex++;
				continue;
			}
			
			if(pushIndex == push.length)
				return false;
			
			while(push[pushIndex] != pop[popIndex])
			{
				stack.push(push[pushIndex]);
				pushIndex++;
			}
			
			if(pushIndex != push.length)
			{		
				pushIndex++;
				popIndex++;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		int[] push = {1,2,3,4,5};
		int[] pop = {4,5,3,1,2};
		SequenceStacks s = new SequenceStacks(push, pop);
		System.out.println(s.checkSequence());
	}
	
}
