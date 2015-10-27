// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    public Iterator<Integer> it;
    private Integer current;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.it = iterator;
	    current = null;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(!this.hasNext())
	        return null;
	        
	    if(current == null)
            current = it.next();
        return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!this.hasNext())
	        return null;
	        
	    if(current != null)
	    {
	        Integer temp = current;
	        current = null;
	        return temp;
	    }
	    return it.next();
	}

	@Override
	public boolean hasNext() {
	    if(!it.hasNext() && current == null)
	        return false;
	        
	    return true;
	}
}