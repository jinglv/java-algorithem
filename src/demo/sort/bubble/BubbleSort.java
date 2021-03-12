package demo.sort.bubble;

import demo.helper.util.ArrayGenerator;
import demo.helper.util.SortingHelper;

/**
 * 冒泡排序
 *
 * @author jinglv
 * @date 2021/03/12
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 记录排序是否已经发生， false是未发生排序， true表示已经发生排序
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            // 每轮外层循环，都将初始化flag为false，表示未排序
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortingHelper.swap(arr, j, j + 1);
                    // 如果元素发生排序交换，则将flag赋值true
                    flag = true;
                }
            }
            // 如果比较晚一趟，没有发生置换，那么说明已经排序好了，不需要在执行下去了，即可终止循环
            if (flag = false) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 1000;
        int n2 = 10000;
        int n3 = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n1, n1);
        Integer[] arr2 = ArrayGenerator.generateRandomArray(n2, n2);
        Integer[] arr3 = ArrayGenerator.generateRandomArray(n3, n3);
        // 选择排序，数组为：10000(一千)
        SortingHelper.sortTest("BubbleSort", arr1);
        // 选择排序，数组为：100000(一万)
        SortingHelper.sortTest("BubbleSort", arr2);
        // 选择排序，数组为：1000000(十万)
        SortingHelper.sortTest("BubbleSort", arr3);
    }
}
