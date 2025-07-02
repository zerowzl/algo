package com.zerowzl.heap;

import java.util.Comparator;

/**
 * 优先队列实现
 * 基于堆的优先队列，可以是最小优先队列或最大优先队列
 * 
 * @author OpenHands
 * @param <T> 队列中元素的类型
 */
public class PriorityQueue<T extends Comparable<T>> {
    
    // 内部使用的堆
    private final AbstractHeap<T> heap;
    
    /**
     * 创建一个最小优先队列
     */
    public PriorityQueue() {
        this.heap = new MinHeap<>();
    }
    
    /**
     * 创建一个指定类型的优先队列
     * 
     * @param isMinQueue 如果为true，创建最小优先队列；否则创建最大优先队列
     */
    public PriorityQueue(boolean isMinQueue) {
        this.heap = isMinQueue ? new MinHeap<>() : new MaxHeap<>();
    }
    
    /**
     * 使用指定比较器创建优先队列
     * 
     * @param comparator 元素比较器
     */
    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = new MinHeap<T>(comparator);
    }
    
    /**
     * 使用指定比较器和类型创建优先队列
     * 
     * @param comparator 元素比较器
     * @param isMinQueue 如果为true，创建最小优先队列；否则创建最大优先队列
     */
    public PriorityQueue(Comparator<? super T> comparator, boolean isMinQueue) {
        this.heap = isMinQueue ? 
                new MinHeap<T>(comparator) : 
                new MaxHeap<T>(comparator);
    }
    
    /**
     * 向队列中添加元素
     * 
     * @param element 要添加的元素
     */
    public void add(T element) {
        heap.insert(element);
    }
    
    /**
     * 获取但不移除队列的头部元素
     * 
     * @return 队列的头部元素
     */
    public T peek() {
        return heap.peek();
    }
    
    /**
     * 获取并移除队列的头部元素
     * 
     * @return 队列的头部元素
     */
    public T poll() {
        return heap.poll();
    }
    
    /**
     * 获取队列的大小
     * 
     * @return 队列中元素的数量
     */
    public int size() {
        return heap.size();
    }
    
    /**
     * 检查队列是否为空
     * 
     * @return 如果队列为空则返回true，否则返回false
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    /**
     * 清空队列
     */
    public void clear() {
        heap.clear();
    }
    
    /**
     * 返回队列的字符串表示
     */
    @Override
    public String toString() {
        return heap.toString();
    }
}