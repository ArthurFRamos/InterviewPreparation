
import java.util.*;


public class RadixSort
{
  
 	private int[] array;
  	private ArrayList<LinkedList<Integer>> buckets = new ArrayList<>(10);
  	private int[] helper;
  
  	public RadixSort(int [] array)
    {
      	this.array = array;
      	
     	for(int i = 0; i < 10; i++) 
          buckets.add(new LinkedList<Integer>());
      	
      	helper = new int[array.length];
      
      	for(int i = 0; i < array.length; i++)
          helper[i] = array[i];
    }
  	
  	public void sort()
    {
      	if(array == null)
          return;
      	    
        int loop = getHighestNumber();
      	
      	for(int i = 0; i < loop; i++)
        {
          	for(int j = 0; j < helper.length; j++)
            {
         		int current = getDigit(helper[j],i);
          		buckets.get(current).add(helper[j]);
          	
            }
          
             int currentPos = 0;
          	
          	for(int j = 0; j < buckets.size(); j++)
            {
               
             	while(!buckets.get(j).isEmpty())
                {
                  	
                 	helper[currentPos] = buckets.get(j).poll();
                  	currentPos++;
                }
            }
        }
      	
      	for(int i = 0; i < array.length; i++)
        	array[i] = helper[i];
    }
  
  	private int getHighestNumber()
    {
     	int highest = Integer.MIN_VALUE;
      	
      	for(int i = 0; i < array.length; i++)
        {
         	int number = getNumberDigits(array[i]);
          
          	if(number > highest)
              	highest = number;
        }
      
      	return highest;
    }
  	
  	private int getDigit(int number, int index)
    {
     	int mod = 10;
      	
      	for(int i = 0; i < index; i++)
         	mod *= 10;
      	
      	
      	return (number%mod)/(mod/10);
    }
  	
  	private int getNumberDigits(int number)
    {
     	if(number == 0)
          return 1;
      	
      	int numbers = 0;
      
      	while(number != 0)
        {
         	 number /= 10;
             numbers++;
        }
      
      	return numbers;
    }
  	
  public static void main (String [] args)
  {
    int a[] = {5,50,20,40,100,5000,495};
   	RadixSort r = new RadixSort(a); 
    r.sort();
    
    for(int i = 0; i < a.length; i++)
     	System.out.print(a[i] + " ");
    
    
  }
}