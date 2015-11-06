package Exercises;

import java.util.HashMap;

public class PeopleTower {

	
	class People implements Comparable<People>
	{
		public int height;
		public int weight;
		
		public People(int height, int weight)
		{
			this.height = height;
			this.weight = weight;
		}
		
		public int compareTo(People other)
		{
			if(this.height < other.height && this.weight < other.weight)
				return -1;
			else if(height > other.height && weight > other.weight)
				return 1;
			else
				return 0;
		}
	}
	
	public People[] tower;
	private HashMap<Integer,Integer> map;
	
	public PeopleTower(People[] tower)
	{
		this.tower = tower;
		map = new HashMap<>();
	}
	
	public int maxLength()
	{
		int max = 0;
		
		for(int i = 0; i < tower.length; i++)
		{
			int temp = lis(i);
			if(temp > max)
				max = temp;
		}
		
		return max;
	}
	
	private int lis(int pos)
	{
		if(map.containsKey(pos))
			return map.get(pos);
		
		int max = 0;
		
		for(int i = 0; i < tower.length; i++)
		{
			if(tower[pos].compareTo(tower[i]) < 0)
			{
				int temp = 1 + lis(i);
				if(temp > max)
					max = temp;
			}
		}
		
		map.put(pos, max);
		
		return max;
	}
}
