/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode bubbleSortList(ListNode head) {
        ListNode temp = head;
        ListNode tem = new ListNode(0);
        tem.next = null;
        if(temp == null)    return null;
        if(temp.next==null)   return head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        while(count>0){
            while(temp.next!=null){
                tem = temp.next;
                if(temp.val>tem.val){
                    int swap = tem.val;
                    tem.val = temp.val;
                    temp.val = swap;
                }
                temp = temp.next;
            }
            temp = head;
            count--;
        }
        return head;
    }
}