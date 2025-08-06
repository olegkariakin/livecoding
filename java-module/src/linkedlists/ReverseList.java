package linkedlists;

public class ReverseList {

    // Reverse iteratively
    public static ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Reverse recursively
    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Print LinkedList to console
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Initial list: ");
        printList(head);

        ListNode reversedList = reverseListRecursively(head);
        System.out.println("After reversing: ");
        printList(reversedList);
    }
}
