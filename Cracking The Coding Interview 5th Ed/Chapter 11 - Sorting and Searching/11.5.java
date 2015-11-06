	public int binarySearchWithSpace(String[] words, String value)
	{
		int begin = 0;
		int end = words.length - 1;
		int currentPos = -1;
		
		while(begin <= end)
		{
			int mid = (begin + end)/2;
			currentPos = mid;
			if(words[mid].equals(" "))
			{
				for(int i = mid + 1; i < words.length; i++)
				{
					if(!words[i].equals(" "))
					{
						currentPos = i;
						break;
					}
				}
				
				if(currentPos == -1)
				{
					for(int i = mid - 1; i >= 0; i--)
					{
						if(!words[i].equals(" "))
						{
							currentPos = i;
							break;
						}
					}
				}
				
				if(currentPos == -1)
					return -1;
			}
			
			if(words[currentPos].compareTo(value) == 0)
				return currentPos;
			else if(words[currentPos].compareTo(value) > 0)
				end = Math.min(mid, currentPos) - 1;
			else
				begin = Math.max(mid, currentPos) + 1;	
		}
		
		return -1;
	}