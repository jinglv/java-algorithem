package demo.structure.queue;

/**
 * @author jingLv
 * @date 2020/12/03
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 队列中添加元素
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 队列中删除数据
     *
     * @return
     */
    E dequeue();

    E getFront();
}
