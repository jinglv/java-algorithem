package demo.structure.queue;

/**
 * 队列的基本实现--接口
 *
 * @author jingLv
 * @date 2020/12/03
 */
public interface Queue<E> {

    /**
     * 队列中元素的个数
     *
     * @return 元素的个数
     */
    int getSize();

    /**
     * 队列中是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 队列中添加元素
     *
     * @param e 添加的元素
     */
    void enqueue(E e);

    /**
     * 队列中删除数据
     *
     * @return 删除的元素
     */
    E dequeue();

    /**
     * 获取队列队头的元素
     *
     * @return 队头的元素
     */
    E getFront();
}
