
import java.util.*;

public class MergeSort
{
 	private int[] array;
  	private int[] helper;
  
  	public MergeSort(int[] array)
    {
     	this.array = array; 
      	this.helper = new int[array.length];
    }
  
  	public void sort()
    {
  		sort(0, array.length - 1);    
    }
  
  	private void sort(int low, int high)
    {
      	int middle = (low + high)/2;

      	
     	if(low < high)
        {
      	   	sort(low,middle);
          	sort(middle + 1, high);
          	merge(low,high);
        }
    }
  
  public void merge(int low, int high)
  {
    	for(int i = low; i <= high; i++)
         	helper[i] = array[i];
        
  		int middle = (low + high)/2;
    	int current = low;
    	int helperLeft = low;
    	int helperRight = middle + 1;
    	
    	while(helperLeft <= middle && helperRight <= high)
        {
        	if(helper[helperLeft] <= (helper[helperRight]))
            {
             	 array[current] = helper[helperLeft];
              	 helperLeft++;
            }
          	else
            {
             	array[current] = helper[helperRight];
              	helperRight++;
            }
          	current++;
        }
    
    	int remaining = middle - helperLeft;
    
    	for(int i = 0; i <= remaining; i++)
         	array[current + i] =  helper[helperLeft + i];

    
  }
  
  public static void main (String [] args)
  {
    	int[] a = {3,2,1,5,4};

   		MergeSort s = new MergeSort(a); 
    	
    	s.sort();
    
    	for(int i = 0; i < a.length; i++)
         	System.out.print(a[i] + " "); 
        
  }
  
}