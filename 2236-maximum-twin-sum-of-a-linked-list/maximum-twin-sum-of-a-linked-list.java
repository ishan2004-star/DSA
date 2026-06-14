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
        public int pairSum(ListNode head) {
            int target;ListNode curr=head;int n=0;ListNode seed=null;int i=0;ListNode q;
            while(curr!=null){n++;curr=curr.next;}curr=head;

            while(curr!=null){
                if(i>(n/2)-1){q=curr.next;curr.next=seed;seed=curr;curr=q;}
                else{i++;curr=curr.next;}} 

            
            curr=head;
            target=curr.val+seed.val;
            curr=curr.next;seed=seed.next;
            while(seed!=null){
                if(seed.val+curr.val>target){target=seed.val+curr.val;}
                curr=curr.next;seed=seed.next;}

            

            return target;
        }
    }