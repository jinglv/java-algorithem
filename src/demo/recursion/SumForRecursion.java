package demo.recursion;

/**
 * 递归求和
 *
 * @author jingLv
 * @date 2020/12/14
 */
public class SumForRecursion {

    /**
     * 递归求arr中所有元素的和
     *
     * @param arr 数组
     * @return 求和的值
     */
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n)这个区间内所有数字的和
     *
     * @param arr 数组
     * @param l   数组的起始值（左边界的索引值）
     * @return 求和的值
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
