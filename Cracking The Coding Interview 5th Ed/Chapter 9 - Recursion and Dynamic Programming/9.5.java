	public ArrayList<String> getPermutation(String word) 
	{
        ArrayList<String> current = new ArrayList<>();
        
        if(word.length() == 0)
            return current;
                    
        current = permutations(word, word.length() - 1);
        
        return current;
    }
    
    private ArrayList<String> permutations(String base, int level)
    {
        ArrayList<String> previous = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        
        if(level == 0)
        {
            buffer.append(base.charAt(0));
            previous.add(buffer.toString());
            return previous;
        }
        
        previous = permutations(base, level - 1);
        char currentChar = base.charAt(level);
        
        ArrayList<String> current = new ArrayList<>();
        int currentPos = 0;
        
        for(int i = 0; i < previous.size(); i++)
        {
            while(currentPos <= previous.get(i).length())
            {
                buffer = new StringBuffer();
                for(int j = 0; j < currentPos; j++)
                    buffer.append(previous.get(i).charAt(j));
                
                buffer.append(currentChar);
                
                for(int j = currentPos; j < previous.get(i).length(); j++)
                    buffer.append(previous.get(i).charAt(j));
                
                current.add(buffer.toString());
                
                currentPos++;
            }
            
            currentPos = 0;
        }
        
        return current;
    }