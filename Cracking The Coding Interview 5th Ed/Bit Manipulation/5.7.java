public int findMissing(int[] array)
    {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i : array)
    		list.add(i);
    	int missing = 0;

    	int count0 = 0;
    	int count1 = 0;
    	int position = 0;
    	int currentBit = 0;
    	while(!list.isEmpty())
    	{
        	int parity = list.size() %2;
    		for(int i : list)
    		{
    			int tempBit = getBit(i, position);
    			if(tempBit == 1)
    				count1++;
    			else
    				count0++;
    		}
    		
    		if((parity == 0 && count1 == count0 )|| (parity == 1 && count1 > count0))
    			currentBit = 0;
    		
    		else
    			currentBit = 1;
    		
    		missing |= currentBit << position;
    		
    		for(int i = 0; i < list.size(); i++)
    			if(getBit(list.get(i),position) != currentBit)
    			{
    				list.remove(i);
    				i--;
    			}
    		count0 = 0;
    		count1 = 0;
    		position++;
    	}
    	
    	return missing;
    }
	
	private int getBit(int num, int pos)
	{
		boolean temp = ((num & (1 << pos)) != 0);
		return temp ? 1 : 0;
	}