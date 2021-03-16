package demo.structure.stack;

/**
 * 测试数组实现栈
 *
 * @author jingLv
 * @date 2020/12/10
 */
public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
