# Algo - Data Structures and Algorithms Implementation

This repository contains implementations of various data structures and algorithms in Java. It serves as both a learning resource and a reference for common algorithms and data structures used in computer science.

## Overview

The implementations are organized by topic, with each section focusing on a specific data structure or algorithmic paradigm. Most implementations include detailed comments explaining the logic and time/space complexity analysis.

Feel free to explore the code, use it for learning purposes, or contribute your own implementations!

### Example Usage

Here's a simple example of using the DynamicArray implementation:

```java
import com.zerowzl.array.DynamicArray;

public class Example {
    public static void main(String[] args) {
        // Create a new dynamic array with initial capacity of 5
        DynamicArray<Integer> array = new DynamicArray<>(5);
        
        // Add elements
        array.add(1);
        array.add(2);
        array.add(3);
        
        // Get element at index
        Integer value = array.get(1);  // Returns 2
        
        // Print the array
        System.out.println(array);  // Output: [1, 2, 3]
        
        // Remove element
        array.remove(1);
        System.out.println(array);  // Output: [1, 3]
    }
}

## Data Structures and Algorithms

### 数组 (Arrays)
- 实现一个支持动态扩容的数组 [DynamicArray](/workspace/algo/src/main/java/com/zerowzl/array/DynamicArray.java)
- 实现一个大小固定的有序数组，支持动态增删改操作 
- 实现两个有序数组合并为一个有序数组

### 链表 (Linked Lists)
- 实现单链表 [SimpleLinkedList](/workspace/algo/src/main/java/com/zerowzl/linkedList/SimpleLinkedList.java)、循环链表、双向链表，支持增删操作
- 实现单链表反转
- 实现两个有序的链表合并为一个有序链表
- 实现求链表的中间结点

### 栈 (Stacks)
- 用数组实现一个顺序栈
- 用链表实现一个链式栈
- 编程模拟实现一个浏览器的前进、后退功能

### 队列 (Queues)
- 用数组实现一个顺序队列
- 用链表实现一个链式队列
- 实现一个循环队列

### 递归 (Recursion)
- 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2) [Fibonacci](/workspace/algo/src/main/java/com/zerowzl/recursion/Fibonacci.java)
- 编程实现求阶乘 n! [Factorial](/workspace/algo/src/main/java/com/zerowzl/recursion/Factorial.java)
- 编程实现一组数据集合的全排列 [Permute](/workspace/algo/src/main/java/com/zerowzl/recursion/Permute.java), [PermuteV2](/workspace/algo/src/main/java/com/zerowzl/recursion/PermuteV2.java)
- 分解质因数 [Factorization](/workspace/algo/src/main/java/com/zerowzl/recursion/Factorization.java)
- 选择硬币面额问题 [SelectDenomination](/workspace/algo/src/main/java/com/zerowzl/recursion/SelectDenomination.java)
- 暴力破解密码 [BruteForce](/workspace/algo/src/main/java/com/zerowzl/recursion/BruteForce.java)

### 排序 (Sorting)
- 实现归并排序 [MergeSort](/workspace/algo/src/main/java/com/zerowzl/sort/MergeSort.java)、快速排序 [QuickSort](/workspace/algo/src/main/java/com/zerowzl/sort/QuickSort.java)、插入排序 [InsertionSort](/workspace/algo/src/main/java/com/zerowzl/sort/InsertionSort.java)、冒泡排序 [BubbleSort](/workspace/algo/src/main/java/com/zerowzl/sort/BubbleSort.java)、选择排序 [SelectSort](/workspace/algo/src/main/java/com/zerowzl/sort/SelectSort.java) 
- 计数排序 [CountingSort](/workspace/algo/src/main/java/com/zerowzl/sort/CountingSort.java)   
- 编程实现 O(n) 时间复杂度内找到一组数据的第 K 大元素 [KthMax](/workspace/algo/src/main/java/com/zerowzl/sort/KthMax.java)

### 二分查找 (Binary Search)
- 实现一个有序数组的二分查找算法 [BinarySearch](/workspace/algo/src/main/java/com/zerowzl/search/BinarySearch.java)
- 实现模糊二分查找算法（比如大于等于给定值的第一个元素）[BinarySearch](/workspace/algo/src/main/java/com/zerowzl/search/BinarySearch.java)

### 散列表和字符串 (Hash Tables and Strings)
- 实现一个基于链表法解决冲突问题的散列表
- 实现一个 LRU 缓存淘汰算法

### 字符串 (Strings)
- 实现一个字符集，只包含 a～z 这 26 个英文字母的 Trie 树
- 实现朴素的字符串匹配算法

### 二叉树 (Binary Trees)
- 实现一个二叉查找树，并且支持插入、删除、查找操作
- 实现查找二叉查找树中某个节点的后继、前驱节点
- 实现二叉树前、中、后序以及按层遍历

### 堆 (Heaps)
- 实现一个小顶堆 [MinHeap](/workspace/algo/src/main/java/com/zerowzl/heap/MinHeap.java)、大顶堆 [MaxHeap](/workspace/algo/src/main/java/com/zerowzl/heap/MaxHeap.java)、优先级队列 [PriorityQueue](/workspace/algo/src/main/java/com/zerowzl/heap/PriorityQueue.java)
- 实现堆排序（已在MinHeap和MaxHeap中实现）
- 通用堆实现 [AbstractHeap](/workspace/algo/src/main/java/com/zerowzl/heap/AbstractHeap.java)
- 堆的使用示例 [HeapDemo](/workspace/algo/src/main/java/com/zerowzl/heap/HeapDemo.java)
- 利用优先级队列合并 K 个有序数组
- 求一组动态数据集合的最大 Top K

### 图 (Graphs)
- 实现有向图、无向图、有权图、无权图的邻接矩阵和邻接表表示方法 
- 实现图的深度优先搜索、广度优先搜索
- 实现 Dijkstra 算法、A* 算法
- 实现拓扑排序的 Kahn 算法、DFS 算法

### 回溯 (Backtracking)
- 利用回溯算法求解八皇后问题
- 利用回溯算法求解 0-1 背包问题

### 分治 (Divide and Conquer)
- 利用分治算法求一组数据的逆序对个数

### 动态规划 (Dynamic Programming)
- 0-1 背包问题
- 最小路径和
- 编程实现莱文斯坦最短编辑距离
- 编程实现查找两个字符串的最长公共子序列
- 编程实现一个数据序列的最长递增子序列

## How to Contribute

Contributions to this repository are welcome! Here's how you can contribute:

1. Fork the repository
2. Create a new branch for your feature or bug fix
3. Implement your changes
4. Add appropriate tests if applicable
5. Submit a pull request

Please ensure your code follows the existing style and includes proper documentation.

## License

This project is available for educational and reference purposes.
