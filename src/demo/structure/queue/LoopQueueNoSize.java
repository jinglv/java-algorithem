package demo.structure.queue;

/**
 * 使用size实现队列，会浪费一个空间
 *
 * @author jinglv
 * @date 2021/03/15
 */
public class LoopQueueNoSize<E> implements Queue<E> {
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
     * 构造函数，初始化队列
     *
     * @param capacity 数组的容量
     */
    public LoopQueueNoSize(int capacity) {
        // 由于不浪费空间，所以data静态数组的大小是capacity，而不是capacity+1
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
    }

    /**
     * 构造函数，初始化队列，默认容量为10
     */
    public LoopQueueNoSize() {
        this(10);
    }

    @Override
    public int getSize() {
        // 此时的getSize的逻辑
        // 如果tail>=front，非常简单，队列中的元素个数就是tail-front
        // 如果tail<front，说明我们的循环队列"循环"起来了，此时队列中的元素个数为：tail-front+data.length
        // 也可以理解成，此时，data中没有元素的数目为front-tail
        // 整体元素个数就是data.length-(front-tail)=data.length+tail-front
        return tail >= front ? tail - front : tail - front + data.length;
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
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 队列中添加元素
     *
     * @param e 添加的元素
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
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
        // 出队的低于队列长度的四分之一，则进缩容
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
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
        int sz = getSize();
        for (int i = 0; i < sz; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = sz;
    }

    /**
     * 格式化输出循环队列
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size = %d, capacity = %d \n", getSize(), getCapacity()));
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

    public static void main(String[] args) {
        LoopQueueNoSize<Integer> queue = new LoopQueueNoSize<>();
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
