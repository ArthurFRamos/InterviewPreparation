	public String stringCompression(String word)
	{
		if(word.length() == 0)
			return " ";
		
		char current = word.charAt(0);
		int count = 1;
		
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 1; i < word.length(); i++)
		{
			char temp = word.charAt(i);
			
			if(temp != current)
			{
				buffer.append(current);
				buffer.append(count);
				count = 1;
				current = temp;
			}
			else
				count++;
		}
		
		buffer.append(current);
		buffer.append(count);
		
		if(buffer.length() < word.length())
			return buffer.toString();
		
		return word;
	}
	