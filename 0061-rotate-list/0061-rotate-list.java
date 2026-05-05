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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode tail=null;
        int len=0;
        while(temp!=null){
            if(temp.next==null) tail =temp;
            temp=temp.next;
            len++;
        }
        k=k%len;
        if(k==0) return head;
        temp=head;
        for(int i=1;i<len-k;i++){
            temp=temp.next;
        }
        tail.next=head;
        head=temp.next;
        temp.next=null;
        return head;

        
    }
}