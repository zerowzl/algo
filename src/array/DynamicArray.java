package array;

import java.util.Arrays;

/**
 * 实现一个支持动态扩容的数组
 *
 * @author Dave Wang
 */
public class DynamicArray<E> {
    /**
     * 容量
     */
    private int capacity;
    /**
     * 元素数量
     */
    private int size;
    /**
     * 实际存放元素的数组
     */
    private Object[] data;

    public DynamicArray() {
        this.capacity = 10;
        this.data = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    /**
     * 添加元素，没有考虑 capacity 的最大界限
     *
     * @param element 整数
     */
    public void add(E element) {
        if (size == capacity) {
            // 满了，扩容1.5倍
            capacity = capacity + (capacity >> 1);
            data = Arrays.copyOf(data, capacity);
        }
        data[size++] = element;
    }

    /**
     * 根据下标获取元素
     *
     * @param index 下标
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return (E) data[index];
    }


    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);
        dynamicArray.add(1);
        dynamicArray.add(1);
        dynamicArray.add(2);
        System.out.println(dynamicArray.get(2));
    }

}
