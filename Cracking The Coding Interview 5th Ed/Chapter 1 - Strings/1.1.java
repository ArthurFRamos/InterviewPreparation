	public boolean checkUniqueChar(String word)
	{
		if(word.length() > 26)
			return false;
		
		int mask = 0;
		
		for(int i = 0; i < word.length(); i++)
		{
			int temp = 1;
			int pos = word.charAt(i) - 'a';
			
			if((mask & temp << pos) == 0)
				return false;
			
			mask |= i << pos;
		}
		
		return true;
	}