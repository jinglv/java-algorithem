package demo.structure.queue;

/**
 * 链表实现队列
 *
 * @author jingLv
 * @date 2020/12/10
 */
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 节点设置为私有的内部类，对于用户不需要知道节点的实现细节
     */
    private class Node {
        /**
         * 数据域
         */
        public E e;
        /**
         * 指针（引用）
         */
        public Node next;

        /**
         * Node构造函数
         *
         * @param e    数据
         * @param next 指针
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * Node构造函数
         *
         * @param e 数据
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * Node构造函数
         */
        public Node() {
            this(null, null);
        }

        /**
         * 链表格式化输出
         *
         * @return string
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * head 头节点
     * tail 尾节点
     */
    private Node head, tail;
    /**
     * 链表队列中元素的个数
     */
    private int size;

    /**
     * 构造函数--初始化链表队列
     */
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 获取列表中元素的个数
     *
     * @return 元素的个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断列表是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列中添加元素从尾进行添加，入队
     *
     * @param e 入队的元素
     */
    @Override
    public void enqueue(E e) {
        // tail为空则head也为空，如果链表中有元素则tail会指向tail的元素
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 队列中删除数据，出队
     *
     * @return 出队的元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        // 出队的元素指向head
        Node resultNode = head;
        // 则当前head指向到head下一个节点
        head = head.next;
        // 将出队的元素置为null
        resultNode.next = null;
        // head节点可能为空，如果head为空，则tail也为空，链表队列无元素的情况
        if (head == null) {
            tail = null;
        }
        // 元素个数自减
        size--;
        return resultNode.e;
    }

    /**
     * 查看队首的元素
     *
     * @return 队头元素
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    /**
     * 链表格式化输出
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node current = head;
        while (current != null) {
            res.append(current).append("->");
            current = current.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
