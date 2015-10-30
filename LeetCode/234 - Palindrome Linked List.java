/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode begin; 
    public boolean isPalindrome(ListNode head) {
        begin = head;
        if(head == null)
            return true;
        if(head.next == null)
            return true;
            
            return helper(head);
            
    }
    
    public boolean helper(ListNode end)
    {
        boolean palindrome = true;
        
        if(end.next == null)
        {
            if(begin.val != end.val)
                return false;
            begin = begin.next;
            return true;
        }
        
        else
           palindrome = palindrome && helper(end.next);
        
        if(begin.val != end.val)
        	return false;
        
        begin = begin.next;
        return palindrome;
    }
}