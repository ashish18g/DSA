package ashish.btech.dsa.lc.easy;

import java.util.Arrays;

class Node {

    Node next;
    Node prev;
    int val;

    public Node() {
        val = 0;
        next = null;
        prev = null;
    }

    public Node(int val) {
        this.val = val;
        next = null;
        prev = null;
    }

    public Node(int val, Node prev) {
        this.val = val;
        this.next = null;
        this.prev = prev;
    }
}

public class LC1046 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        Node temp = new Node(stones[0]);
        for (int a = 1; a < stones.length; a++) {
            temp.next = new Node(stones[a], temp);
            temp = temp.next;
        }

        while (temp != null && temp.prev != null) {
            int p = temp.val - temp.prev.val;
            if (p == 0) {
                temp = temp.prev.prev;
                if (temp == null) {
                    return 0;
                } else {
                    temp.next = null;
                }
            } else {
                temp.prev.val = p;
                temp = temp.prev;
                temp.next = null;
            }

            Node tempX = temp;
            while (tempX.prev != null && tempX.prev.val > tempX.val) {
                int t = tempX.val;
                tempX.val = tempX.prev.val;
                tempX = tempX.prev;
                tempX.val = t;
            }
        }

        return temp.val;
    }

    public static void main(String[] args) {
        LC1046 blah = new LC1046();
        int[] bruh = {1};
        System.out.println(blah.lastStoneWeight(bruh));
    }
}
