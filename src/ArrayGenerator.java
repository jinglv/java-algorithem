/**
 * 数组生成器
 *
 * @author jingLv
 * @date 2020/11/13
 */
public class ArrayGenerator {
    /**
     * 构造方法，外部不能实例化
     */
    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
