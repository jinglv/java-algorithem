package demo.sort.util;

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

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        if ("SelectionSort".equals(sortName)) {
            SelectionSort.sort(arr);
        } else if ("InsertionSort".equals(sortName)) {
            InsertionSort.sort(arr);
        } else if ("InsertionSort2".equals(sortName)) {
            InsertionSort.sortPlus(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(String.format("%s, n = %d : %f s", sortName, arr.length, time));
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
