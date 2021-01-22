package demo.recursion;

/**
 * leetcode203题
 *
 * @author jingLv
 * @date 2020/12/14
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // 头节点不为空，且头节点的值等于给定的值
        while (head != null && head.val == val) {
            // 删除节点的过程
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 如果头节点为空，则链表为空，直接返回null
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeE(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 使虚拟节点解决问题
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsDummy(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 使用递归解决问题
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode result = removeElementsRecursion(head.next, val);
//        if (head.val == val) {
//            return result;
//        } else {
//            head.next = result;
//        }
//        return head;
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode result = (new Solution()).removeElementsRecursion(head, 6);
        System.out.println(result);
    }
}
