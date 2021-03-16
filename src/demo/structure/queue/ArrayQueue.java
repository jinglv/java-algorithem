package demo.structure.queue;

import demo.structure.array.Array;

/**
 * 数组实现线性队列
 *
 * @author jingLv
 * @date 2020/12/03
 */
public class ArrayQueue<E> implements Queue<E> {
    /**
     * 定义数组
     */
    Array<E> array;

    /**
     * 构造函数--初始化数组
     *
     * @param capacity 数组容量
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 获取栈中元素的个数
     *
     * @return 元素的个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取队列数组的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 队列中添加元素
     *
     * @param e 添加的元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 队列删除元素
     *
     * @return 删除的元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 获取队列的队头的元素
     *
     * @return 队头的元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 格式化输出队列
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue:");
        result.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1) {
                result.append(",");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
