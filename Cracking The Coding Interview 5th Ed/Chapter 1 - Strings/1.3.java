	public boolean checkAnagram(String first, String second)
	{
		HashMap<Character,Integer> map = new HashMap<>();
		
		if(second.length() != first.length())
			return false;
		
		for(int i = 0; i < first.length(); i++)
		{
		
			char temp = first.charAt(i);
			char temp2 = second.charAt(i);
			
			if(!map.containsKey(temp))
				map.put(temp, 1);
			else
			{
				int count = map.get(temp);
				map.put(temp, count + 1);
			}
			
			if(!map.containsKey(temp2))
				map.put(temp2,-1);
			else
			{
				int count = map.get(temp2);
				map.put(temp2, count -1);
			}
		}
		
		for(Character i : map.keySet())
			if(map.get(i) != 0)
				return false;
		
		return true;
	}
	