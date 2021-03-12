package demo.sort.selection;

import demo.helper.util.ArrayGenerator;
import demo.helper.util.SortingHelper;

/**
 * 选择排序
 * 选择排序(Selection sort)是⼀种简单直观的排序算法。
 * ⼯作原理是每⼀次从待排序的数据元素中选出最⼩(或最⼤)的⼀个元素，存放在序列的起始(末尾)位置，直到全部待排序的数据元素排完。
 * <p>
 * 规律：
 * - ⼀个数组是需要 n-1 趟排序的(因为直到剩下⼀个元素时，才不需要找最⼤值)
 * - 每交换1次，再次找最⼤值时就将范围缩⼩1
 * - 查询当前趟数最⼤值实际上不⽤知道最⼤值是多少(上⾯我查出最⼤值，还要我⼿动数它的⻆标)，知道它的数组⻆标即可，交换也是根据⻆标来进⾏交换
 *
 * @author jingLv
 * @date 2020/11/16
 */
public class SelectionSort {

    private SelectionSort() {
    }

    /**
     * 选择排序算法，数组从左到右排序
     *
     * @param arr 数组
     * @param <E> 数组中元素类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 循环不变量：arr[0...i)是有序的；arr[i...n)是无序的
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i...n)中的最小值的索引，并赋值给minIndex
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换元素
            SortingHelper.swap(arr, i, minIndex);
        }
    }

    /**
     * 选择排序算法，数组从右到左排序
     *
     * @param arr 数组
     * @param <E> 数组中元素类型
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = arr.length - 1; i < arr.length; i--) {
            // 取数组中最后一个数为最大值
            int maxIndex = i;
            for (int j = i; j < arr.length; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            // 交换元素
            SortingHelper.swap(arr, i, maxIndex);
        }
    }

    /**
     * 选择排序算法，开辟新空间
     *
     * @param arr 数组
     * @param <E> 数组中元素类型
     */
    public static <E extends Comparable<E>> void sortSpace(E[] arr) {
        // 开辟一个新的数组，将每轮选择的最小数字，加入到该数组中，注意：泛型数组的需要强转
        E[] newArr = (E[]) new Object[arr.length];
        // 循环数组，进行比较，将每轮最最小的值放入到newArr新的数组中
        for (E value : arr) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].compareTo(value) < 0) {
                    newArr[j] = arr[j];
                }
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
        SortingHelper.sortTest("SelectionSort", arr1);
        // 选择排序，数组为：100000(一万)
        SortingHelper.sortTest("SelectionSort", arr2);
        // 选择排序，数组为：1000000(十万)
        SortingHelper.sortTest("SelectionSort", arr3);
    }
}
