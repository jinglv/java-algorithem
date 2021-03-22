package demo.structure.linked;

import javafx.util.Pair;

/**
 * 使用递归的方式实现链表
 *
 * @author jinglv
 * @date 2021/03/22
 */
public class LinkedListForRecursion<E> {

    private class Node {
        /**
         * 节点中的元素
         */
        public E e;
        /**
         * 指针
         */
        public Node next;

        /**
         * 构造函数--初始化节点
         *
         * @param e    元素
         * @param next 指针
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * 构造函数--初始化节点
         *
         * @param e 元素
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * 构造函数--初始化节点
         */
        public Node() {
            this(null, null);
        }

        /**
         * 元素字符串输出
         *
         * @return String
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表中的头节点
     */
    private Node head;
    /**
     * 链表中元素的个数
     */
    private int size;

    /**
     * 无参构造函数--初始化链表
     */
    public LinkedListForRecursion() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     *
     * @return 元素的个数
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
     * 链表中添加元素
     *
     * @param index 位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        head = add(head, index, e);
        size++;
    }

    /**
     * 在以node为头节点的链表index位置插入元素e--递归算法
     *
     * @param node  头节点
     * @param index 位置
     * @param e     元素
     * @return 节点
     */
    private Node add(Node node, int index, E e) {
        // 如果插入的位置是头节点
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    /**
     * 在链表头添加的元素e
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾天机新的元素e
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index(0-based)个位置的元素
     *
     * @param index 位置
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        return get(head, index);
    }

    /**
     * 在以node为头节点的链表在，找到第index个元素--递归算法
     *
     * @param node  头节点
     * @param index 位置
     * @return 元素
     */
    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    /**
     * 获取链表的第一个元素
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     *
     * @param index 位置
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        set(head, index, e);
    }

    /**
     * 修改以node为头节点的链表中，第index(0-based)个位置的元素为e--递归算法
     *
     * @param node  节点
     * @param index 位置
     * @param e     元素
     */
    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        return contains(head, e);
    }

    /**
     * 以node为节点的链表中，查找是都存在元素e--递归算法
     *
     * @param node 节点
     * @param e    元素
     * @return boolean
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    /**
     * 从链表删除index(0-based)位置元素，返回删除的元素
     *
     * @param index 位置
     * @return 元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    /**
     * 以node为头节点的链表中，删除第index位置的元素--递归算法
     * 返回值包含两个元素，删除后的链表头节点和删除的值
     *
     * @param node  节点
     * @param index 位置
     * @return 节点元素
     */
    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     *
     * @return 元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     *
     * @return 元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除指定的元素
     *
     * @param e 元素
     */
    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    /**
     * 以node为头节点的链表中，删除元素e--递归算法
     *
     * @param node 节点
     * @param e    元素
     * @return 节点
     */
    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.equals(e)) {
            size--;
            return node.next;
        }
        node.next = removeElement(node.next, e);
        return node;
    }

    /**
     * 格式化输出链表
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = head;
        while (current != null) {
            res.append(current).append("->");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListForRecursion<Integer> list = new LinkedListForRecursion<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        System.out.println(list);
        while (!list.isEmpty()) {
            System.out.println("removed:" + list.removeLast());
        }
    }
}
