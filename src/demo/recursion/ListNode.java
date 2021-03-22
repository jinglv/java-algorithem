package demo.recursion;

/**
 * 定义ListNode，在leetcode203题中使用
 *
 * @author jingLv
 * @date 2020/12/14
 */
public class ListNode {
    /**
     * 值
     */
    int val;
    /**
     * 节点
     */
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 链表节点的构造函数
     * 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
     *
     * @param arr 数组
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        // 将数组的第一个元素设置为链表的第一个节点
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    /**
     * 以当前节点为头节点的链表信息字符串
     *
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
