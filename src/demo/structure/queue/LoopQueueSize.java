package demo.structure.queue;

/**
 * 使用size，不浪费一个空间
 *
 * @author jinglv
 * @date 2021/03/15
 */
public class LoopQueueSize<E> implements Queue<E> {
    /**
     * 队列的数组
     */
    private E[] data;
    /**
     * front队头
     * tail队尾
     */
    private int front, tail;
    /**
     * 队列存储元素的数量
     */
    private int size;

    /**
     * 构造函数，初始化队列
     *
     * @param capacity 数组的容量
     */
    public LoopQueueSize(int capacity) {
        // 由于不浪费空间，所以data静态数组的大小是capacity，而不是capacity+1
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 构造函数，初始化队列，默认容量为10
     */
    public LoopQueueSize() {
        this(10);
    }

    /**
     * 获取队列中元素的个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 获取数组队列的数组容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        // 不再使用front和tail之间的关系来判断队列是否为空，而是直接使用size
        return size == 0;
    }

    /**
     * 队列中添加元素
     *
     * @param e 添加的元素
     */
    @Override
    public void enqueue(E e) {
        // 使用size判断队列是否已满
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 删除队列中的元素
     *
     * @return 删除的元素
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
        E[] newData = (E[]) new Object[newCapacity];
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
        for (int i = 0; i < size; i++) {
            res.append(data[(front + 1) % data.length]);
            // 指向不是最后一个元素
            if ((i + front + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueSize<Integer> queue = new LoopQueueSize<>();
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
