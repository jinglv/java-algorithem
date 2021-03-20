package demo.structure.queue;

/**
 * 链表队列测试类
 *
 * @author jingLv
 * @date 2020/12/10
 */
public class LinkedListQueueMain {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
