package demo.structure.queue;

/**
 * 数组实现循环队列
 *
 * @author jingLv
 * @date 2020/12/03
 */
public class LoopQueue<E> implements Queue<E> {
    /**
     * 队列元素
     */
    private E[] data;
    /**
     * front 队头
     * tail 队尾
     */
    private int front, tail;
    /**
     * 队列存储元素的数量
     */
    private int size;

    /**
     * 构造函数--初始化队列
     * front=tail为空数组
     *
     * @param capacity 数组的容量
     */
    public LoopQueue(int capacity) {
        // 循环队列，有意识的浪费一个单位
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造函数--默认初始化数组容量为10
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取数组队列的数组容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 获取队列中元素个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 队列中添加元素（入队）
     *
     * @param e 添加的元素
     */
    @Override
    public void enqueue(E e) {
        // 入队查询队列是否是满的
        if ((tail + 1) % data.length == front) {
            // 队列是满的则进行2倍扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 队列中删除数据(出队)
     *
     * @return 删除队列的元素
     */
    @Override
    public E dequeue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 出队的低于队列长度的四分之一，则进缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 获取队列的队头元素
     *
     * @return 队头元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    /**
     * 队列的扩容
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 格式化输出循环队列
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size = %d, capacity = %d \n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            // 指向不是最后一个元素
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
