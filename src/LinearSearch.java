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
        int n = 10000000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        long startTime = System.nanoTime();
        search(data, n);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(time + "s");
//        int search1 = search(data, 666);
//        System.out.println(search1);
//        // 定义查找数组
//        Student[] students = {
//                new Student("Alice"),
//                new Student("Mimi"),
//                new Student("Charles")
//        };
//        // 定义查找对象
//        Student mimi = new Student("Mimi");
//        // 调用查找方法，期望是比较两个类对象的字符串
//        int search2 = LinearSearch.search(students, mimi);
//        System.out.println(search2);
    }
}
