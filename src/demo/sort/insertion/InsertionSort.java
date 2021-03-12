package demo.sort.insertion;

import demo.helper.util.ArrayGenerator;
import demo.helper.util.SortingHelper;

import java.util.Arrays;

/**
 * @author jingLv
 * @date 2020/11/19
 */
public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * 插入排序算法
     *
     * @param arr 数组
     * @param <E> 数组元素的类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortingHelper.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 插入排序算法--语句合并
     *
     * @param arr 数组
     * @param <E> 数组元素的类型
     */
    public static <E extends Comparable<E>> void sortMerge(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将if语句合并到一起
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortingHelper.swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 插入排序算法优化
     *
     * @param arr 数组
     * @param <E> 数组元素的类型
     */
    public static <E extends Comparable<E>> void sortPlus(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 暂存元素
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                // 前面的元素，赋值给当前元素（相当于平移）
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // 暂存元素
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && arr[j].compareTo(arr[j + 1]) > 0; j--) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {1000, 10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSortPlus", arr2);
        }
    }
}
