package linkedlists;

public class CheckPalindromeLinkedList {

    static void main() {
        ListNode head = initializeLinkedList();
        System.out.println(checkLinkedListIsPalindrome(head));
    }

    private static ListNode initializeLinkedList() {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next = new ListNode(3);
        head.next.next = next;
        next = new ListNode(2);
        head.next.next.next = next;
        next = new ListNode(1);
        head.next.next.next.next = next;
        return head;
    }

    private static boolean checkLinkedListIsPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. find middle of the list using fast and slow pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }

        // 3. check first half vs second half
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
