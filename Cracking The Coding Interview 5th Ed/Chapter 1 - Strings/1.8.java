	//private boolean isSubstring(String s1, String s2);

	public boolean isRotation(String s1, String s2)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(s1);
		buffer.append(s1);
		
		s1 = buffer.toString();
		
		return isSubstring(s1,s2);
	}