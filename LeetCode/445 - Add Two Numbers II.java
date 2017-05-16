/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        ListNode current = l1;
        
        while(current != null)
        {
            stack1.push(current.val);
            current = current.next;
        }
        
        current = l2;
        while(current != null)
        {
            stack2.push(current.val);
            current = current.next;   
        }
        
        if(stack1.size() < stack2.size())
        {
            Stack<Integer> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        
        int overflow = 0;
        current = null;
        while(!stack1.empty())
        {
            int temp1 = stack1.pop();
            int temp2 = 0;
            if(!stack2.empty())
                temp2 = stack2.pop();
            
            int sum = temp1 + temp2 + overflow;
            if(sum >= 10)
            {
                sum -= 10;
                overflow = 1;
            }
            else
                overflow = 0;
            ListNode toAdd = new ListNode(sum);
            toAdd.next = current;
            current = toAdd;
        }
        
        if(overflow == 1)
        {
            ListNode toAdd = new ListNode(1);
            toAdd.next = current;
            current = toAdd;
        }
        return current;
    }
}