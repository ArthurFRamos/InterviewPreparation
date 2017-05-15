/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null)
            return null;
            
        HashMap<Integer,RandomListNode> map = new HashMap<>();
        
        RandomListNode current = head;
        RandomListNode newCurrent = new RandomListNode(head.label);
        RandomListNode newHead = newCurrent;
        map.put(newCurrent.label,newCurrent);
        
        while(current != null)
        {
            if(current.next == null)
                newCurrent.next = null;
            else
            {
                if(map.containsKey(current.next.label))
                {
                    RandomListNode temp = map.get(current.next.label);
                    newCurrent.next = temp;
                }
                else
                {
                    newCurrent.next = new RandomListNode(current.next.label);
                    map.put(current.next.label, newCurrent.next);
                }
            }
            
            if(current.random == null)
                newCurrent.random = null;
            else
            {
                if(map.containsKey(current.random.label))
                {
                    RandomListNode temp = map.get(current.random.label);
                    newCurrent.random = temp;
                }
                else
                {
                    newCurrent.random = new RandomListNode(current.random.label);
                    map.put(current.random.label,newCurrent.random);
                }
            }
            
            current = current.next;
            newCurrent = newCurrent.next;
        }
        
        return newHead;
    }
}