public class UpdatingLinkedList extends DoublyLinkedList<Long> {

    public void insertNumber(long number) {
        Node<Long> trav = tail;
        if (head == null || head.data >= number) {
            addFirst(number);
        } else if (tail.data <= number) {
            addLast(number);
        } else {
            while (trav.data > number) {
                trav = trav.prev;
            }
            Node<Long> num = new Node<>(number, trav, trav.next);
            trav.next.prev = num;
            trav.next = num;
        }
    }
}
