



import java.util.*;
import java.lang.*;
import java.io.*;

//Generic Quicksort

public class Quicksort<T extends Comparable<T>>
{
  
  public T[] array;
  
  public Quicksort(T[] array)
  {
    this.array = array;
  }
  
  public void sort()
  {
  		quicksort(0,array.length - 1);
  }
  
  private void quicksort(int left, int right)
  {
   		int index = partition(left,right);
    	if(left < index - 1)
        	quicksort(left, index - 1);
    	if(right > index)
          	quicksort(index,right);
  }
  
  private int partition(int left, int right)
  {
		T pivot = array[(left + right)/2];
    	
    	while(left <= right)
        {
         	while(array[left].compareTo(pivot) < 0)
            	left++;
          	while(array[right].compareTo(pivot) > 0)
              	right--;
          	if(left <= right)
            {
            	swap(left,right);
              	left++;
              	right--;
            }
        }
    	
    	return left;
  }
  
  private void swap(int left, int right)
  {
   		T temp = array[left];
    	array[left] = array[right];
    	array[right] = temp;
  }
  
  public static void main(String[] args)
  {

   	Integer[] values = new Integer[3];
    values[0] = 5;
    values[1] = 10;
    values[2] = 3;
       	Quicksort<Integer> sorter = new Quicksort<Integer>(values);
    sorter.sort();
    
    for(int i = 0; i < values.length; i++)
      	System.out.print(values[i] + " ");
    
    
  }
}