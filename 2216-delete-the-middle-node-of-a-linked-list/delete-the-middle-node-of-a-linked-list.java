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
        public ListNode deleteMiddle(ListNode head) {

            if(head==null || head.next==null){return head.next;}

            ListNode curr=head;int i=0;int n=0;

            while(curr!=null){n++;curr=curr.next;}curr=head;
            while(i+1!=n/2){curr=curr.next;i++;}
            curr.next=curr.next.next;

            return head;
        }
    }