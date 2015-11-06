   public String sortString(String base)
   {
	   char[] temp = base.toCharArray();
	   Arrays.sort(temp);
	   
	   return new String(temp);
	   
   }
   public void sortAnagrams(String[] array)
   {
	   HashMap<String,ArrayList<String>> map = new HashMap<>();
	   int currentPosition = 0;
	   for(String i : array)
	   {
		   String temp = sortString(i);
		   if(!map.containsKey(temp))
			   map.put(temp, new ArrayList<String>());
		  
		   ArrayList<String> list = map.get(temp);
		   list.add(i);
	   }
	   
	   for(String i : map.keySet())
	   {
		   ArrayList<String> list = map.get(i);
		   for(String j : list)
			   array[currentPosition++] = j;
	   }
   