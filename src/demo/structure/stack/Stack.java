package demo.structure.stack;

/**
 * 栈的基本实现--接口
 *
 * @author jingLv
 * @date 2020/11/30
 */
public interface Stack<E> {

    /**
     * 获取栈的个数
     *
     * @return 元素个数
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e 入栈的元素
     */
    void push(E e);

    /**
     * 弹栈
     *
     * @return 弹栈的元素
     */
    E pop();

    /**
     * 返回栈顶元素
     *
     * @return 栈顶元素
     */
    E peek();
}
