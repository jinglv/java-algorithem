package demo.helper.util;

import demo.sort.bubble.BubbleSort;
import demo.sort.insertion.InsertionSort;
import demo.sort.selection.SelectionSort;

/**
 * 验证排序算法正确的帮助类
 *
 * @author jingLv
 * @date 2020/11/18
 */
public class SortingHelper {

    private SortingHelper() {
    }

    /**
     * 验证数组是否有序
     *
     * @param arr 待验证的数组
     * @param <E> 类型
     * @return Boolean
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证排序方法的时间
     *
     * @param sortName 排序方法名称
     * @param arr      待排序数组
     * @param <E>      类型
     */
    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        // 当前纳秒的时间
        long startTime = System.nanoTime();
        if ("SelectionSort".equals(sortName)) {
            SelectionSort.sort(arr);
        } else if ("InsertionSort".equals(sortName)) {
            InsertionSort.sort(arr);
        } else if ("InsertionSortPlus".equals(sortName)) {
            InsertionSort.sortPlus(arr);
        } else if ("BubbleSort".equals(sortName)) {
            BubbleSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.printf("%s, n = %d : %f s%n", sortName, arr.length, time);
    }

    /**
     * 交换数组的元素
     *
     * @param arr 数组
     * @param i   元素i
     * @param j   元素j
     * @param <E> 类型
     */
    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
