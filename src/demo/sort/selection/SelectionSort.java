package demo.sort.selection;

import demo.sort.util.ArrayGenerator;
import demo.sort.util.SortingHelper;

/**
 * @author jingLv
 * @date 2020/11/16
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i...n)中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换元素
            swap(arr, i, minIndex);
        }
    }

    public static void sortSpace(int[] arr) {
        // 开辟一个新的数组，将每轮选择的最小数字，加入到该数组中
        int[] newArr = new int[arr.length - 1];
        // 循环数组，进行比较，将每轮最最小的值放入到newArr新的数组中
        for (int value : arr) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < value) {
                    newArr[j] = arr[j];
                }
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("SelectionSort", arr);
    }
}
