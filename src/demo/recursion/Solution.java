package demo.recursion;

/**
 * 打印输出方式 -- 递归算法的调试
 *
 * @author jinglv
 * @date 2021/03/22
 */
public class Solution {

    /**
     * 递归删除链表节点
     *
     * @param head  头节点
     * @param val   删除的节点
     * @param depth 递归调用深度
     * @return 已删除节点的链表
     */
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return:" + head);
            return null;
        }
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove:" + val + ":" + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return:" + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            // 每深度调用一次，添加"--"，掉用的越深，则得到的字符串越长
            result.append("--");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new Solution()).removeElements(head, 6, 0);
        System.out.println(res);
    }
}