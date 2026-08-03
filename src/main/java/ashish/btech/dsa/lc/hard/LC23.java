package ashish.btech.dsa.lc.hard;

import ashish.btech.dsa.structures.ListNode;
import ashish.btech.dsa.lc.easy.LC21;

public class LC23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalList = new ListNode();
        if (lists.length < 1) return null;
        else finalList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            finalList = LC21.mergeTwoLists(finalList, lists[i]);
        }

        return finalList;
    }
}
