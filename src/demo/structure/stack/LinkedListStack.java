package demo.structure.stack;

import demo.structure.linked.LinkedList;

/**
 * 链表实现栈
 *
 * @author jingLv
 * @date 2020/12/10
 */
public class LinkedListStack<E> implements Stack<E> {
    /**
     * 电仪列表
     */
    private LinkedList<E> list;

    /**
     * 构造函数--初始化链表
     */
    public LinkedListStack() {
        list = new LinkedList<>();
    }

    /**
     * 获取列表中元素个数
     *
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断链表是否为空
     *
     * @return Boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈
     *
     * @param e 入栈的元素
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * 出栈
     *
     * @return 出栈的元素
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 获取栈顶的元素
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    /**
     * 格式化输出栈
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Stack: top " + list;
    }
}
