package demo.structure.queue;

/**
 * 双端队列
 *
 * @author jinglv
 * @date 2021/03/16
 */
public class Deque<E> {
    /**
     * 队列中的元素数据
     */
    private E[] data;
    /**
     * front 队首
     * tail 队尾
     */
    private int front, tail;
    /**
     * 队列中元素的个数
     */
    private int size;

    /**
     * 构造函数--队列初始化
     *
     * @param capacity 容量
     */
    public Deque(int capacity) {
        // 使用size，Deque实现不浪费空间
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 构造函数--队列初始化
     */
    public Deque() {
        this(10);
    }

    /**
     * 获取队列的容量
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
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取队列中元素的个数
     *
     * @return 元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 队列队尾添加元素
     *
     * @param e 添加匀速
     */
    public void addLast(E e) {
        // 判断队列是否已满
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        // 将元素添加到队尾
        data[tail] = e;
        // 队尾指针向后移
        tail = (tail + 1) % data.length;
        // 队列元素个数增加
        size++;
    }

    /**
     * 队列队首添加元素
     *
     * @param e 添加元素
     */
    public void addFront(E e) {
        // 判断队列是否已满
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        // 我们首先要确定添加新元素的索引的位置，这个位置是front-1的地方
        // 但是要注意，如果front==0，新的位置是data.length-1的位置
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    /**
     * 队列队首删除元素
     *
     * @return 删除元素
     */
    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        // 获取删除的元素
        E ret = data[front];
        // 将队首的元素置为null
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 队列队尾删除元素
     *
     * @return 删除元素
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        // 计算删除掉队尾元素以后，新的tail位置
        tail = tail == 0 ? data.length - 1 : tail - 1;
        // 获取删除的元素
        E ret = data[tail];
        data[tail] = null;
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 获取队首的元素
     *
     * @return 队首元素
     */
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return data[front];
    }

    /**
     * 获取队尾的元素
     *
     * @return 队尾元素
     */
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        // 因为tail指向的是队尾的下一个位置，我们需要计算下一个真正队尾元素的索引
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    /**
     * 队列扩容
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
     * 格式化输出队列
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue:size=%d,capacity=%d", getSize(), getCapacity()));
        builder.append("front [");
        for (int i = 0; i < size; i++) {
            builder.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        // 双端队列测试红，偶数从队尾加入，奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                dq.addLast(i);
            } else {
                dq.addFront(i);
            }
            System.out.println(dq);
        }
        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for (int i = 0; !dq.isEmpty(); i++) {
            if (i % 2 == 0) {
                dq.removeFront();
            } else {
                dq.removeLast();
            }
            System.out.println(dq);
        }
    }
}
