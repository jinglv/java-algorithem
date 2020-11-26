package demo.array;

/**
 * @author jingLv
 * @date 2020/11/26
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e 元素
     */
    public void addLast(int e) {
//        // 如果数组已满，则不能添加元素
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed.Array is full");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 向所有元素头添加一个新元素
     *
     * @param e 元素
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index位置插入一个新元素e
     *
     * @param index 指定位置
     * @param e     元素
     */
    public void add(int index, int e) {
        // 如果数组已满，则不能添加元素
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed.Array is full");
        }
        // index不能小于0，也不能大于数组的长度
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed.Array is full");
        }

        for (int i = size - 1; i >= index; i--) {
            // 后一个元素赋值前一个元素的值
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引值
     * @return 返回元素
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素e
     *
     * @param index 索引位置
     * @param e     元素
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 数组格式化输出
     *
     * @return 返回格式化数组
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
