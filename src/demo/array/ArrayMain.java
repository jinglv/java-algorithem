package demo.array;

/**
 * @author jingLv
 * @date 2020/11/26
 */
public class ArrayMain {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);
        
        array.addFirst(-1);
        System.out.println(array);
    }
}
