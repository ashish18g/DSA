package ashish.btech.dsa.lc.easy;

import ashish.btech.dsa.structures.ListNode;

public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalList = new ListNode();
        ListNode node = finalList;
        while (list1 != null && list2 != null) {
            if (list2.val > list1.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        node.next = list1 != null ? list1 : list2;

        return finalList.next;
    }

    public static void main(String[] args) {
        ListNode nums1 = ListNode.listToNodes(new int[] {1, 2, 4});
        ListNode nums2 = ListNode.listToNodes(new int[] {1, 3, 4});

        LC21 blah = new LC21();
        ListNode finalblah = blah.mergeTwoLists(nums1, nums2);

        System.out.println(finalblah);
    }
}
