public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    private LinkedList<Integer> numbers = new LinkedList<>();
    private HashSet<Integer> flags = new HashSet<>();
    
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0; i < maxNumbers; i++)
            numbers.add(i);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(numbers.isEmpty())
            return -1;
        int temp = numbers.poll();
        flags.add(temp);
        
        return temp;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !flags.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!flags.contains(number))
            return;
        flags.remove(number);
        numbers.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */