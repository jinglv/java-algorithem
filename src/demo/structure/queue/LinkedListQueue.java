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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列中添加元素，入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
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
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node resultNode = head;
        head = head.next;
        resultNode.next = null;
        if (head == null) {
            tail = null;
        }
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
