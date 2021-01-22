package demo.linear;

/**
 * 线性查找算法
 *
 * @author jingLv
 * @date 2020/11/09
 */
public class LinearSearch {

    /**
     * 外部无法实例化
     */
    private LinearSearch() {
    }

    /**
     * @param data   需要查找的数组
     * @param target 查找的目标元素
     * @param <E>    数据类型
     * @return 返回找到的目标元素的索引
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            // 默认比较的是类对象的地址
            if (data[i].equals(target)) {
                // 找到目标元素返回该元素的下标
                return i;
            }
        }
        // 未找到目标元素返回-1
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int i = search(data, 16);
        System.out.println("目标元素的位置：" + i);

        Student[] students = {new Student("Alice"), new Student("Bobo"), new Student("Charles")};
        Student bobo = new Student("Bobo");
        int i1 = search(students, bobo);
        System.out.println(i1);
    }
}
