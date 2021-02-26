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

    public static <E extends Comparable<E>> void sortMerge(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将if语句合并到一起
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortingHelper.swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sortPlus(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 暂存元素
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {1000, 10000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSort2", arr2);
        }
    }
}
