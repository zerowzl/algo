package com.zerowzl.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 抽象堆实现，提供堆的基本操作
 * 
 * @author OpenHands
 * @param <T> 堆中元素的类型
 */
public abstract class AbstractHeap<T> {
    
    // 存储堆元素的数组
    protected Object[] elements;
    
    // 堆中元素的数量
    protected int size;
    
    // 堆的初始容量
    protected static final int DEFAULT_CAPACITY = 10;
    
    // 元素比较器
    protected final Comparator<? super T> comparator;
    
    /**
     * 使用默认容量和比较器构造堆
     * 
     * @param comparator 元素比较器
     */
    public AbstractHeap(Comparator<? super T> comparator) {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }
    
    /**
     * 使用指定容量和比较器构造堆
     * 
     * @param initialCapacity 初始容量
     * @param comparator 元素比较器
     */
    public AbstractHeap(int initialCapacity, Comparator<? super T> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Initial capacity must be at least 1");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
        this.comparator = comparator;
    }
    
    /**
     * 向堆中插入一个元素
     * 
     * @param element 要插入的元素
     */
    public void insert(T element) {
        if (element == null) {
            throw new NullPointerException("Cannot insert null element");
        }
        
        // 如果数组已满，扩容
        if (size == elements.length) {
            grow();
        }
        
        // 将元素添加到堆的末尾
        elements[size] = element;
        size++;
        
        // 上浮操作，维护堆的性质
        siftUp(size - 1);
    }
    
    /**
     * 获取堆顶元素但不移除
     * 
     * @return 堆顶元素
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) elements[0];
    }
    
    /**
     * 移除并返回堆顶元素
     * 
     * @return 堆顶元素
     */
    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0) {
            return null;
        }
        
        // 获取堆顶元素
        T result = (T) elements[0];
        
        // 将最后一个元素移到堆顶
        elements[0] = elements[size - 1];
        elements[size - 1] = null; // 帮助GC
        size--;
        
        // 如果堆不为空，执行下沉操作
        if (size > 0) {
            siftDown(0);
        }
        
        return result;
    }
    
    /**
     * 获取堆的大小
     * 
     * @return 堆中元素的数量
     */
    public int size() {
        return size;
    }
    
    /**
     * 检查堆是否为空
     * 
     * @return 如果堆为空则返回true，否则返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * 清空堆
     */
    public void clear() {
        // 清空数组中的所有元素
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    
    /**
     * 扩容操作
     */
    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 扩容为原来的1.5倍
        elements = Arrays.copyOf(elements, newCapacity);
    }
    
    /**
     * 上浮操作，用于维护堆的性质
     * 
     * @param index 需要上浮的元素索引
     */
    @SuppressWarnings("unchecked")
    protected void siftUp(int index) {
        T element = (T) elements[index];
        
        while (index > 0) {
            int parentIndex = (index - 1) >>> 1; // 父节点索引
            T parent = (T) elements[parentIndex];
            
            // 如果当前元素不需要上浮，则退出循环
            if (compare(element, parent) >= 0) {
                break;
            }
            
            // 将父节点下移
            elements[index] = parent;
            index = parentIndex;
        }
        
        // 将元素放到最终位置
        elements[index] = element;
    }
    
    /**
     * 下沉操作，用于维护堆的性质
     * 
     * @param index 需要下沉的元素索引
     */
    @SuppressWarnings("unchecked")
    protected void siftDown(int index) {
        T element = (T) elements[index];
        int half = size >>> 1; // 只需要检查到非叶子节点
        
        while (index < half) {
            int childIndex = (index << 1) + 1; // 左子节点索引
            T child = (T) elements[childIndex];
            
            int rightIndex = childIndex + 1; // 右子节点索引
            
            // 如果右子节点存在且比左子节点更小，则选择右子节点
            if (rightIndex < size && compare((T) elements[rightIndex], child) < 0) {
                childIndex = rightIndex;
                child = (T) elements[rightIndex];
            }
            
            // 如果当前元素不需要下沉，则退出循环
            if (compare(element, child) <= 0) {
                break;
            }
            
            // 将子节点上移
            elements[index] = child;
            index = childIndex;
        }
        
        // 将元素放到最终位置
        elements[index] = element;
    }
    
    /**
     * 比较两个元素
     * 
     * @param a 第一个元素
     * @param b 第二个元素
     * @return 比较结果
     */
    protected int compare(T a, T b) {
        return comparator.compare(a, b);
    }
    
    /**
     * 将堆转换为数组
     * 
     * @return 包含堆中所有元素的数组
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Arrays.copyOf(elements, size);
    }
    
    /**
     * 返回堆的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}