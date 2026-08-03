package ashish.btech.dsa.lc.hard;

import ashish.btech.dsa.structures.ListNode;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode newHead = head;
        for (int i = 1; i < k; i++) {
            if (newHead == null) return head;
            newHead = newHead.next;
        }

        if (newHead == null) return head;
        ListNode afterNewHead = newHead.next;

        ListNode node = newHead;

        while (head != node) {
            ListNode tempTrav = head;
            while (tempTrav.next != node) {
                tempTrav = tempTrav.next;
            }
            node.next = tempTrav;
            node = node.next;
        }

        head.next = afterNewHead;

        head.next = reverseKGroup(afterNewHead, k);

        return newHead;
    }

    public static void main(String[] args) {
        LC25 blah = new LC25();

        ListNode head = ListNode.listToNodes(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        head = blah.reverseKGroup(head, 10);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
