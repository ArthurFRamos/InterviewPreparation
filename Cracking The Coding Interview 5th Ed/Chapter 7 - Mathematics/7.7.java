public class MagicNumber {
	
	public int kthNumber(int k)
	{
		if(k == 0)
			return 0;
		int count = 1;
		
		if(k == 1)
			return 1;
		
		LinkedList<Integer> queue3 = new LinkedList<Integer>();
		LinkedList<Integer> queue5 = new LinkedList<Integer>();
		LinkedList<Integer> queue7 = new LinkedList<Integer>();
		
		queue3.add(3);
		queue5.add(5);
		queue7.add(7);
		
		int min = 0;
		
		while(count != k)
		{
			count++;
			min = Math.min(queue3.peek(),Math.min(queue5.peek(), queue7.peek()));
			
			if(min == queue3.peek())
			{
				queue3.add(min*3);
				queue5.add(min*5);
				queue7.add(min*7);
				queue3.poll();
			}
			else if(min == queue5.peek())
			{
				queue5.add(min*5);
				queue7.add(min*7);
				queue5.poll();
			}
			else
			{
				queue7.add(min*7);
				queue7.poll();
			}
		}
		
		return min;
	}