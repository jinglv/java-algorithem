package demo.structure.queue;

/**
 * @author jingLv
 * @date 2020/12/03
 */
public class LoopQueueMain {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            // 入队
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                // 出队
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
