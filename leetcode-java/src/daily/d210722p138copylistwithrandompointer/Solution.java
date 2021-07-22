package daily.d210722p138copylistwithrandompointer;

/**
 * 138. Copy List with Random Pointer
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes
 * in the copied list such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 *
 * Your code will only be given the head of the original linked list.
 */

public class Solution {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) { this.val = val; this.next = null; this.random = null; }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        for (var curr = head; curr != null; curr = curr.next.next) {
            var copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;
        }

        for (var curr = head; curr != null; curr = curr.next.next) {
            if (curr.random != null) curr.next.random = curr.random.next;
        }

        Node result = new Node(0);
        for (Node curr = head, copy = result; curr != null; curr = curr.next, copy = copy.next) {
            copy.next = curr.next;
            curr.next = curr.next.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        assert new Solution().copyRandomList(null) == null;
    }

}
