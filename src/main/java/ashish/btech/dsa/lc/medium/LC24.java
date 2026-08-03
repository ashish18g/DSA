package ashish.btech.dsa.lc.medium;

import ashish.btech.dsa.structures.ListNode;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        while (head != null && head.next != null) {
            ListNode nextPair = head.next.next;
            head.next.next = head;
            if (nextPair == null || nextPair.next == null) head.next = nextPair;
            else head.next = nextPair.next;
            head = nextPair;
            nextPair = null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LC24 blah = new LC24();

        ListNode head = ListNode.listToNodes(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        head = blah.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
