package demo.structure.stack;

/**
 * @author jingLv
 * @date 2020/11/30
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
