	
	public void removeSpaces(char[] word, int trueLength)
	{
		int currentPos = word.length - 1;
		
		for(int i = trueLength - 1; i >= 0; i--)
		{
			if(word[i] == ' ')
			{
				word[currentPos] = '0';
				word[currentPos - 1] = '2';
				word[currentPos - 2] = '%';
				currentPos = currentPos - 3;
			}
			else
			{
				word[currentPos] = word[i];
				currentPos--;
			}
		}
	}
