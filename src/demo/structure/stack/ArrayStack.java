package demo.structure.stack;

import demo.structure.array.Array;

/**
 * 数组实现栈
 *
 * @author jingLv
 * @date 2020/11/30
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 定义数组
     */
    Array<E> array;

    /**
     * 构造函数--初始化栈
     *
     * @param capacity 数组的容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 栈中元素的个数
     *
     * @return 元素的个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入栈
     *
     * @param e 入栈的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 弹栈
     *
     * @return 弹出栈的元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取栈顶的元素
     *
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 数组实现栈的容量
     *
     * @return 容量值
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 格式化输出栈
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack:");
        result.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1) {
                result.append(",");
            }
        }
        result.append("] top");
        return result.toString();
    }
}
