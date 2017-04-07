

import java.util.*;
import java.lang.*;
import java.io.*;

public class Pair<T,E>
{
  	public T key;
 	public E value;

  	public Pair(T key, E value)
  	{
    	this.key = key;
    	this.value = value;
  	}
  
 	public boolean equals(Pair<T,E> other)
    {
    	if(other == null)
         	return false;
      	return key.equals(other.key);
    }
}

public class HashMap<T,E>
{

  
  	private ArrayList<ArrayList<Pair<T,E>>> buckets;
  	private double loadFactor;
  	private int load;
  
  	public HashMap(int size, double loadFactor)
    {
    	  this.buckets = new ArrayList<ArrayList<Pair<T,E>>>(size);
      	  this.loadFactor = loadFactor;
      	  this.load = 0;
      
      	  for(int i = 0; i < size; i++)
          	buckets.add(new ArrayList<Pair<T,E>>()); 
          
    }
  
  	public HashMap()
    {
    	this(16,0.75);
    }
  
  	private void reHash()
    {
   		double loadProportion = ((double) load)/buckets.size();
  
      	if(loadProportion >= loadFactor)
        {        
          	int size = buckets.size();
          
        	buckets.ensureCapacity(size * 2);
          
      		for(int i = 0; i < size; i++)
          		buckets.add(new ArrayList<Pair<T,E>>());
        }
    }
  
  	public void put(T key, E value)
    {
      	//Very important to notice that hash calculations can overflow, giving negative numbers! This avoids array ouf bounds exception...
    	int pos = Math.abs(key.hashCode() % buckets.size());

      	ArrayList<Pair<T,E>> current = buckets.get(pos);
      	
      
      	Pair<T,E> newPair = new Pair<T,E>(key,value);
      	
      	Iterator<Pair<T,E>> it = current.iterator();
      	    
      	
      	while(it.hasNext())
        {
          	System.out.println(key);
        	Pair<T,E> currentPair = it.next();
          	if(currentPair.equals(newPair))
            {
             	currentPair.value = newPair.value;
             	return;
            }
        }
      	if(current.isEmpty())
        	load++;
      	current.add(newPair);
    
      	reHash();
    }
  
  	public E get (T key)
    {
    	int pos = key.hashCode() % buckets.size();
      	
      	Iterator<Pair<T,E>> it = buckets.get(pos).iterator();
      
      	while(it.hasNext())
        {
          	Pair<T,E> current = it.next();
          
         	if(current.key.equals(key))
              return current.value;
        }
      
      	return null;
    }
  
  	public void remove(T key)
    {
    	int pos = key.hashCode() % buckets.size();
      
      	for(int i = 0; i < buckets.get(pos).size(); i++)
        {
         	Pair<T,E> current = buckets.get(pos).get(i);
          	if(current.key.equals(key))
            {
            	buckets.get(pos).remove(i);
              	if(buckets.get(pos).isEmpty())
                	load--;
             	break; 
            }
        }
    }
  
  	public void print()
    {
      	StringBuffer buffer = new StringBuffer();
      
     	for(int i = 0; i < buckets.size(); i++)
        {
          	if(!buckets.get(i).isEmpty())
            {
              	buffer.append("bucket ");
              	buffer.append(i);
              	buffer.append(" ");
            }
          
         	for(int j = 0; j < buckets.get(i).size(); j++)
            {
              	buffer.append("key: ");
              	buffer.append(buckets.get(i).get(j).key.toString());
              	buffer.append(" value ");
              	buffer.append(buckets.get(i).get(j).value.toString());
              	buffer.append(" ");
            }
          	
          	if(!buckets.get(i).isEmpty())
 				buffer.append(System.getProperty("line.separator"));
        }
      
      	buffer.append("current load ");
      	buffer.append(((double) load)/buckets.size());
      	buffer.append(System.getProperty("line.separator"));
      	
      	System.out.print(buffer);
    }
  
  	public static void main(String [] args)
    {
    	HashMap<String,Integer> map = new HashMap<>();
      	map.put("Lais",25);
      	map.put("Arthur", 26);
      	map.put("Arthur2",28);
        map.put("Arthur100",30);
      	map.put("Lais40",40);
      	map.put("Jarisneide",54);
      	map.put("Amanda", 22);
      	map.put("Amanda",24);
      	map.print();
 
		System.out.println(map.get("Amanda"));
  
      	map.print();
    }
  
}