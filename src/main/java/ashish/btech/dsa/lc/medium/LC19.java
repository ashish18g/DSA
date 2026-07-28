package ashish.btech.dsa.lc.medium;

import ashish.btech.dsa.structures.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode node = head.next;
        for (int i = n; i > 0; i--) {

            if (node == null) {
                head = head.next;
                return head;
            }
            node = node.next;
        }

        while (node != null) {
            prev = prev.next;
            node = node.next;
        }
        node = prev.next;
        prev.next = node == null ? node : node.next;
        node = null;
        return head;
    }

    public static void main(String[] args) {
        LC19 blah = new LC19();
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;

        for (int i = 3; i < 6; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = node.next;
        }

        blah.removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
