    public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y)
    {
    	int height = width * y;
    	int firstByte = (height + x1)/8;
    	int firstOff = x1 % 8;
    	int secondByte = (height + x2)/8;
    	int secondOff = x2 % 8;
    	
    	if(firstByte < secondByte)
    	{
    		for(int i = firstByte + 1; i < secondByte; i++)
    			screen[i] = (byte)0xFF;
    		
    		screen[firstByte] |= (1 <<(8 - firstOff)) -1;
    		screen[secondByte] |= ((1 << (secondOff + 1)) - 1) << (7 - secondOff);			
    	}
    	else
    	{
    		int mask = (1 << ((secondOff - firstOff) + 1))- 1;
    		mask <<= 7 - secondOff;
    		screen[firstByte] |= mask;
    	}
    }