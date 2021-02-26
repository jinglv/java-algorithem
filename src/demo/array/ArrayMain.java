package demo.array;

import demo.helper.model.Student;

/**
 * @author jingLv
 * @date 2020/11/26
 */
public class ArrayMain {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        // 默认容量10
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("Alice", 100));
        studentArray.addLast(new Student("Bob", 66));
        studentArray.addLast(new Student("Charlie", 88));
        System.out.println(studentArray);
    }
}
