package demo.sort.selection;

/**
 * @author jingLv
 * @date 2020/11/16
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i...n)中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换元素
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 6, 3, 5};
        sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
