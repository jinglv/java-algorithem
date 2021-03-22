package demo.recursion;

/**
 * leetcode203题：删除连中的元素
 * 删除链表中等于给定值val的所有元素
 *
 * @author jingLv
 * @date 2020/12/14
 */
public class RemoveLinkedNode {
    /**
     * 删除链表中等于给定值val的所有元素
     *
     * @param head 链表头节点
     * @param val  删除的值
     * @return 链表节点
     */
    public ListNode removeElements(ListNode head, int val) {
        // 头节点不为空，且头节点的值等于给定的值（头节点就是需要删除的值），特殊处理
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
        // 需要删除的元素在链表中间
        // 从头节点开始遍历，找到需要删除的节点
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 找到删除的节点
                ListNode delNode = prev.next;
                // 将当前的节点下一个节点指向删除元素指向的下一个节点
                prev.next = delNode.next;
                // 将删除的节点置为空
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 删除链表中等于给定值val的所有元素--优化版
     *
     * @param head 头节点
     * @param val  删除的节点
     * @return 链表节点
     */
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
     * 删除链表中等于给定值val的所有元素--使虚拟头节点
     *
     * @param head 头节点
     * @param val  删除的节点的值
     * @return 链表节点
     */
    public ListNode removeElementsDummy(ListNode head, int val) {
        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        // 虚拟头节点下一个节点是头节点
        dummyHead.next = head;
        // 从头节点开始遍历，找到需要删除的节点
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
     * 删除链表中等于给定值val的所有元素--使用递归解决问题
     *
     * @param head 头节点
     * @param val  删除的节点的值
     * @return 链表节点
     */
    public ListNode removeElementsRecursion(ListNode head, int val) {
        // 如果头节点为空，则链表为空
        if (head == null) {
            return null;
        }
        // 头节点，后面跟着的链表
//        ListNode result = removeElementsRecursion(head.next, val);
//        if (head.val == val) {
//            return result;
//        } else {
//            head.next = result;
//        }
//        return head;
        // 头节点，后面跟着的链表
        head.next = removeElementsRecursion(head.next, val);
        // 实际删除节点的执行代码
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        System.out.println("---------------removeElements---------------");
        int[] nums1 = {1, 2, 6, 3, 4, 5, 6};
        ListNode head1 = new ListNode(nums1);
        System.out.println("未删除元素的链表：" + head1);
        ListNode result1 = (new RemoveLinkedNode()).removeElements(head1, 6);
        System.out.println("已删除元素的链表：" + result1 + ",removeElements");

        System.out.println("---------------removeE---------------");
        int[] nums2 = {1, 2, 6, 3, 4, 5, 6};
        ListNode head2 = new ListNode(nums2);
        System.out.println("未删除元素的链表：" + head2);
        ListNode result2 = (new RemoveLinkedNode()).removeE(head2, 6);
        System.out.println("已删除元素的链表：" + result2 + ",removeE");

        System.out.println("---------------removeElementsDummy---------------");
        int[] nums3 = {1, 2, 6, 3, 4, 5, 6};
        ListNode head3 = new ListNode(nums3);
        System.out.println("未删除元素的链表：" + head3);
        ListNode result3 = (new RemoveLinkedNode()).removeElementsDummy(head2, 6);
        System.out.println("已删除元素的链表：" + result3 + ",removeElementsDummy");

        System.out.println("---------------removeElementsRecursion---------------");
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println("未删除元素的链表：" + head);
        ListNode result = (new RemoveLinkedNode()).removeElementsRecursion(head, 6);
        System.out.println("已删除元素的链表：" + result + ",removeElementsRecursion");
    }
}
