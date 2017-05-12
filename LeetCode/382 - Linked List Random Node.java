/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    HashMap<Integer, Integer> map = new HashMap<>();
    int length = 0;
    
    public Solution(ListNode head) {
        ListNode current = head;
        
        while(current != null)
        {
            length++;
            map.put(length,current.val);
            current = current.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random r = new Random();
        int random = r.nextInt(length) + 1;
        
        return map.get(random);
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */