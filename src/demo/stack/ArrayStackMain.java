package demo.stack;

/**
 * @author jingLv
 * @date 2020/11/30
 */
public class ArrayStackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println("------pop------");
        stack.pop();
        System.out.println(stack);
    }
}
