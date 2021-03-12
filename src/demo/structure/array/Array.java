package demo.structure.array;

/**
 * 自定义Java数组的动态数组
 *
 * @author jingLv
 * @date 2020/11/26
 */
public class Array<E> {

    /**
     * 数组中存储的数据
     */
    private E[] data;
    /**
     * 数组的长度
     */
    private int size;

    /**
     * 构造函数，初始化数组，传入数组的容量capacity构造Array
     *
     * @param capacity 容量（数组长度）
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，初始化数组，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return int
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在第index位置插入一个新元素e
     *
     * @param index 指定位置
     * @param e     元素
     */
    public void add(int index, E e) {
        // index不能小于0，也不能大于数组的长度
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed.Array is full");
        }
        // 如果数组已满，则进行扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
//        for (int i = size - 1; i >= index; i--) {
//            // 后一个元素赋值前一个元素的值
//            data[i + 1] = data[i];
//        }
        // 数组拷贝
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        // 数组中插入元素
        data[index] = e;
        // 数组长度增加
        size++;
    }

    /**
     * 向数组最后一位添加一个新元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头添加一个新元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 获取index索引位置的元素
     *
     * @param index 索引值
     * @return 返回元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    /**
     * 获取数组最后一个元素
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取数组的第一个元素
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素e
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素e
     *
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在索引，如果不存在元素e，则返回-1
     *
     * @param e 元素
     * @return int
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置元素，返回删除元素
     *
     * @param index 元素位置
     * @return 返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        }
        E ret = data[index];
//        for (int i = index + 1; i < size; i++) {
//            data[i - 1] = data[i];
//        }
        // 使用数组拷贝
        if (size - index + 1 >= 0) {
            System.arraycopy(data, index + 1, data, index + 1 - 1, size - index + 1);
        }

        size--;
        // 对象引用置为null，便于垃圾回收
        data[size] = null;
        // 防止复杂度动荡，size小于长度的四分之一时，才进行缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            // 数组缩容
            resize(data.length / 2);
        }
        return ret;
    }


    /**
     * 从数组中删除指定元素
     *
     * @param e 元素
     */
    public void removeElement(E e) {
        // 搜索元素
        int index = find(e);
        // 如果元素存在，则删除
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     *
     * @return 返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     *
     * @return 返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * 数组扩容
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
//        for (int i = 0; i < size; i++) {
//            newData[i] = data[i];
//        }
        // 数组拷贝
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
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
