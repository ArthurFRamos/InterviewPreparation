
import java.lang.Math; 


public class KMP{
  
  	private String text;
  	private String pattern;
  	private int[] lsp;
  
  	public KMP(String text, String pattern)
    {
     	this.text = text;
      	this.pattern = pattern;
      	this.buildLSP();
      
    }
  
  	public int compare()
    {
      	int skip = 0;
      	int index = 0;
      
    	while(index < text.length())
        {
         	if(text.charAt(index) != pattern.charAt(skip))
            {
             	index++;
              	skip = 0;
              	continue;
            }  
          
        	for(int i = skip; i < pattern.length(); i++)
            {
            	if(text.charAt(index) == pattern.charAt(i))
                {
                 	if(i == pattern.length() - 1)
                     	return index - pattern.length() + 1; 
              		index++;
                }
              
              	else
                {
               		skip = lsp[i - 1];
                  	break;
                }
            }
          
        }
      
      	return -1;
    }
  	
  	private void buildLSP()
    {
     	lsp = new int[pattern.length()];
		
      	int i = 0;
      	
      	for(int j = 1; j < lsp.length; j++)
        {
        	if(pattern.charAt(j) == pattern.charAt(i))
            {
             	lsp[j] = i + 1;
              	i++;
              	continue;
            }
          
          	boolean notEqual = false;
          
          	while(pattern.charAt(i) != pattern.charAt(j) && !notEqual)
            {
           		if(i == 0)
                 	notEqual = true; 
                else
                 	i = lsp[i-1]; 
            }
          
          	if(!notEqual)
            {
           		lsp[j] = i + 1; 
             	i++; 
            }
            
        }
    }
  
  	public static void main (String[] args)
    {
     	String text = "all work and no play makes jack a dull boy ";
      	String pattern = "dull";
      
      	KMP s = new KMP(text,pattern);
      	System.out.println(s.compare());
      
      
    }
}