package problem.p83removeduplicatesfromsortedlist;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        for (var c = head; c != null && c.next != null; ) {
            if (c.next.val == c.val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        assert check(new Solution().deleteDuplicates(null));
        assert check(new Solution().deleteDuplicates(build(1)), 1);
        assert check(new Solution().deleteDuplicates(build(1,1,1)), 1);
        assert check(new Solution().deleteDuplicates(build(1,1,1,1,1)), 1);
        assert check(new Solution().deleteDuplicates(build(1,1,2)), 1, 2);
        assert check(new Solution().deleteDuplicates(build(1,1,2,3,3)), 1, 2, 3);
    }

    private static ListNode build(int ...numbers) {
        ListNode list = new ListNode();
        ListNode curr = list;
        for (var n : numbers) {
            curr.next = new ListNode(n);
            curr = curr.next;
        }

        return list.next;
    }

    private static boolean check(ListNode list, int ...numbers) {
        for (var n : numbers) {
            if (list != null && list.val == n) {
                list = list.next;
            } else {
                return false;
            }
        }

        return list == null;
    }

}
