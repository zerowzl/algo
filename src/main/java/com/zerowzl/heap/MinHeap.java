package com.zerowzl.heap;

import java.util.Comparator;

/**
 * 最小堆实现
 * 最小堆是一种特殊的堆，其中每个节点的值都小于或等于其子节点的值
 * 
 * @author OpenHands
 * @param <T> 堆中元素的类型
 */
public class MinHeap<T extends Comparable<T>> extends AbstractHeap<T> {
    
    /**
     * 使用默认容量构造最小堆
     */
    public MinHeap() {
        super((a, b) -> a.compareTo(b)); // 使用自然排序
    }
    
    /**
     * 使用指定容量构造最小堆
     * 
     * @param initialCapacity 初始容量
     */
    public MinHeap(int initialCapacity) {
        super(initialCapacity, (a, b) -> a.compareTo(b)); // 使用自然排序
    }
    
    /**
     * 使用指定比较器构造最小堆
     * 
     * @param comparator 元素比较器
     */
    public MinHeap(Comparator<? super T> comparator) {
        super(comparator);
    }
    
    /**
     * 使用指定容量和比较器构造最小堆
     * 
     * @param initialCapacity 初始容量
     * @param comparator 元素比较器
     */
    public MinHeap(int initialCapacity, Comparator<? super T> comparator) {
        super(initialCapacity, comparator);
    }
    
    /**
     * 从数组构建最小堆
     * 
     * @param array 源数组
     */
    public MinHeap(T[] array) {
        this(array.length);
        
        // 复制数组元素
        System.arraycopy(array, 0, elements, 0, array.length);
        size = array.length;
        
        // 从最后一个非叶子节点开始，自底向上建堆
        for (int i = (size >>> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }
    
    /**
     * 堆排序
     * 
     * @param array 要排序的数组
     */
    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> void sort(E[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        // 构建最小堆
        MinHeap<E> heap = new MinHeap<>(array);
        
        // 依次取出堆顶元素，放入结果数组
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.poll();
        }
    }
    
    /**
     * 获取堆中的最小元素
     * 
     * @return 最小元素
     */
    public T getMin() {
        return peek();
    }
}