package com.zerowzl.heap;

import java.util.Arrays;

/**
 * 堆的演示类
 * 展示最小堆、最大堆和优先队列的使用
 * 
 * @author OpenHands
 */
public class HeapDemo {
    
    public static void main(String[] args) {
        // 测试最小堆
        testMinHeap();
        
        System.out.println("\n----------------------------\n");
        
        // 测试最大堆
        testMaxHeap();
        
        System.out.println("\n----------------------------\n");
        
        // 测试优先队列
        testPriorityQueue();
        
        System.out.println("\n----------------------------\n");
        
        // 测试堆排序
        testHeapSort();
    }
    
    /**
     * 测试最小堆
     */
    private static void testMinHeap() {
        System.out.println("测试最小堆：");
        
        // 创建最小堆
        MinHeap<Integer> minHeap = new MinHeap<>();
        
        // 插入元素
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(10);
        minHeap.insert(7);
        
        System.out.println("最小堆内容: " + minHeap);
        System.out.println("堆大小: " + minHeap.size());
        System.out.println("最小元素: " + minHeap.getMin());
        
        // 依次取出元素（按升序）
        System.out.print("依次取出元素: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
        
        // 从数组构建最小堆
        Integer[] array = {9, 4, 6, 2, 7, 1, 8};
        MinHeap<Integer> heapFromArray = new MinHeap<>(array);
        
        System.out.println("从数组构建的最小堆: " + heapFromArray);
    }
    
    /**
     * 测试最大堆
     */
    private static void testMaxHeap() {
        System.out.println("测试最大堆：");
        
        // 创建最大堆
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        
        // 插入元素
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(7);
        
        System.out.println("最大堆内容: " + maxHeap);
        System.out.println("堆大小: " + maxHeap.size());
        System.out.println("最大元素: " + maxHeap.getMax());
        
        // 依次取出元素（按降序）
        System.out.print("依次取出元素: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // 从数组构建最大堆
        Integer[] array = {9, 4, 6, 2, 7, 1, 8};
        MaxHeap<Integer> heapFromArray = new MaxHeap<>(array);
        
        System.out.println("从数组构建的最大堆: " + heapFromArray);
    }
    
    /**
     * 测试优先队列
     */
    private static void testPriorityQueue() {
        System.out.println("测试优先队列：");
        
        // 创建最小优先队列
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(true);
        
        // 创建最大优先队列
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(false);
        
        // 添加相同的元素到两个队列
        Integer[] elements = {5, 3, 8, 1, 10, 7};
        for (Integer element : elements) {
            minQueue.add(element);
            maxQueue.add(element);
        }
        
        System.out.println("最小优先队列: " + minQueue);
        System.out.println("最大优先队列: " + maxQueue);
        
        // 从最小优先队列取出元素
        System.out.print("从最小优先队列取出元素: ");
        while (!minQueue.isEmpty()) {
            System.out.print(minQueue.poll() + " ");
        }
        System.out.println();
        
        // 从最大优先队列取出元素
        System.out.print("从最大优先队列取出元素: ");
        while (!maxQueue.isEmpty()) {
            System.out.print(maxQueue.poll() + " ");
        }
        System.out.println();
    }
    
    /**
     * 测试堆排序
     */
    private static void testHeapSort() {
        System.out.println("测试堆排序：");
        
        // 使用最小堆进行升序排序
        Integer[] array1 = {9, 4, 6, 2, 7, 1, 8};
        System.out.println("原始数组: " + Arrays.toString(array1));
        
        MinHeap.sort(array1);
        System.out.println("最小堆排序后（升序）: " + Arrays.toString(array1));
        
        // 使用最大堆进行降序排序
        Integer[] array2 = {9, 4, 6, 2, 7, 1, 8};
        System.out.println("原始数组: " + Arrays.toString(array2));
        
        MaxHeap.sort(array2);
        System.out.println("最大堆排序后（降序）: " + Arrays.toString(array2));
    }
}