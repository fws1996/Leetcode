/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        int n = 0;
        ListNode cur = headA;
        ListNode pa = headA;
        ListNode pb = headB;

        while (cur != null) {
            sizeA++;
            cur = cur.next;
        }
        cur = headB;
        while ( cur != null) {
            sizeB++;
            cur = cur.next;
        }

        if (sizeA > sizeB) {
            n = sizeA - sizeB;
            for (int i = 0;i < n; ++i){
                pa = pa.next;
            }
        } else {
            n = sizeB - sizeA;
            for (int i = 0;i < n; ++i){
                pb = pb.next;
            }
        }

        while (pa != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }

        return null;
    }
}