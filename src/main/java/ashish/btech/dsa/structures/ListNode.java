package ashish.btech.dsa.structures;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode listToNodes(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode blah = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            blah.next = node;
            blah = node;
        }
        return head;
    }
}
