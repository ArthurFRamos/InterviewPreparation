package Exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class BoxStack
{
	private HashMap<Integer,Integer> map;
	private int max;
	private Box[] boxes;
	
	class Box implements Comparable<Box>{

		private int height;
		private int width;
		private int depth;

		public Box(int height, int width, int depth)
		{
			this.height = height;
			this.width = width;
			this.depth = depth;
		}

		public int compareTo(Box other)
		{
			if(height < other.height && width < other.width && depth < other.depth)
				return -1;
			if(height > other.height && width > other.width && depth > other.depth)
				return 1;
			else
				return 0;
		}
	}
	
	public BoxStack(Box[] boxes)
	{
		this.boxes = boxes;
		this.max = 0;
		this.map = new HashMap<>();
	}
	
	public int bestStack()
	{
		
		return bestStack(-1,boxes);
	}
	
	private int bestStack(int pos, Box[] boxes)
	{
		
		if(map.containsKey(pos))
			return map.get(pos);
		
		int max = 1;
		int current = 1;
		for(int i = 0; i < boxes.length; i++)
		{
			if(i == -1)
			{
				current = bestStack(i,boxes);
				if(current >= max)
					max = current;
			}
			
			if(i != pos && (boxes[pos].compareTo(boxes[i]) > 0))
			{
				current =  1 + bestStack(i, boxes);
				if(current >= max)
					max = current;
			}
		}
		
		map.put(pos,current);
		
		return current;	
	}
}
