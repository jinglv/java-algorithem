package demo.structure.linked;

/**
 * 链表
 *
 * @author jingLv
 * @date 2020/12/07
 */
public class LinkedList<E> {
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
         * 节点构造函数初始化
         *
         * @param e    元素
         * @param next 指针
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * 节点构造函数初始化
         *
         * @param e 元素
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * 节点构造函数初始化
         */
        public Node() {
            this(null, null);
        }

        /**
         * 节点元素格式化输出
         *
         * @return String
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表的头节点
     */
    private Node dummyHead;
    /**
     * 链表中元素的个数
     */
    private int size;

    /**
     * 无参构造函数，进行数据初始化
     */
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取列表中的元素个数
     *
     * @return 元素个个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作
     *
     * @param index 插入的位置
     * @param e     插入的元素
     */
    public void add(int index, E e) {
        // 判断插入位置的合法性
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        // 从虚拟头节点开始遍历链表，找到需要插入的位置进行元素插入
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        previous.next = new Node(e, previous.next);
        size++;
    }

    /**
     * 在链表头添加新的元素e
     *
     * @param e 添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e 添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作
     *
     * @param index 节点的位置
     * @return 获取的元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed.Illegal index.");
        }
        // 从链表的头节点开始循环遍历找到需要查找的元素
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    /**
     * 获得链表的第一个元素
     *
     * @return 获取链表头元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     *
     * @return 获取链表的尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * 在链表中不是一个常用的操作
     *
     * @param index 节点的位置
     * @param e     修改的节点元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed.Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 查找的元素
     * @return boolean
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素，返回删除的元素
     * 在链表中不是一个常用的操作
     *
     * @param index 节点元素的位置
     * @return 删除的节点元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed.Illegal index.");
        }
        // 从虚拟头节点开始，循环遍历找到需要删除的节点元素之前的节点
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        // 将待删除的节点下一个节点赋值给需要删除的节点
        Node resultNode = previous.next;
        previous.next = resultNode.next;
        resultNode.next = null;
        size--;
        return resultNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     *
     * @return 删除的节点元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     *
     * @return 删除的节点元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node current = dummyHead.next;
//        // while循环遍历链表
//        while (current != null) {
//            res.append(current + "->");
//            current = current.next;
//        }
        // for循环遍历链表
        for (Node current = dummyHead.next; current != null; current = current.next) {
            res.append(current).append("->");
        }
        res.append("NULL");
        return res.toString();
    }
}
