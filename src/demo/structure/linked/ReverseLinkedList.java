package demo.structure.linked;

/**
 * LeetCode206题，Reverse Linked List 反转一个链表
 *
 * @author jinglv
 * @date 2021/03/24
 */
public class ReverseLinkedList {

    /**
     * 反转链表
     *
     * @param head 链表的头节点
     * @return 链表
     */
    public ListNode reverseList(ListNode head) {
        // 定义反转需要的节点
        // 头节点之前的节点NULL
        ListNode pre = null;
        // 当前的节点为头节点
        ListNode cur = head;
        // 防止空指针异常，如果当前节点为空，则不会有下一个节点
        while (cur != null) {
            // 下一个节点为头节点的下一个节点
            ListNode next = cur.next;
            // 当前节点的反转，将头节点指向头节点之前的节点（NULL）
            cur.next = pre;
            // 更新引用
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转链表--递归实现
     *
     * @param head 链表的头节点
     * @return 链表
     */
    public ListNode reverseListR(ListNode head) {
        // 判断链表是否为空，如果为空或者只有一个节点，则不需要反转
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseListNode = reverseListR(head.next);
        head.next.next = head;
        head.next = null;
        return reverseListNode;
    }
}
