package demo.structure.array;

import demo.helper.model.Student;

/**
 * @author jingLv
 * @date 2020/11/26
 */
public class ArrayMain {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < array.getCapacity(); i++) {
            array.addLast(i);
        }
        System.out.println("初始化元素，添加元素，数组为：" + array);

        array.add(1, 100);
        System.out.println("索引位置1添加元素100，数组为：" + array);

        array.addFirst(-1);
        System.out.println("数组头前添加元素值-1，数组为：" + array);

        array.addLast(38);
        System.out.println("数组最后一位后添加元素值38，数组为：" + array);

        array.remove(2);
        System.out.println("索引位置2（数组的第3个元素）删除元素，数组为：" + array);

        array.removeElement(4);
        System.out.println("查找元素的值为4，删除该元素，数组为：" + array);

        // 默认容量10，存入Student类
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("Alice", 100));
        studentArray.addLast(new Student("Bob", 66));
        studentArray.addLast(new Student("Charlie", 88));
        System.out.println("打印数组Student类信息：" + studentArray);
    }
}
