package demo.sort.util;

import java.util.Random;

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

    /**
     * 生成长度为n的顺序数组
     *
     * @param n
     * @return
     */
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成长度为n的随机数组
     *
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
