package org.github.fourth.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LeetCode_215_findKthLargest {

    /**
     *
     */
    public int findKthLargest01(int[] nums, int k) {
        return 0;
    }

    /**
     * 方法一：快速选择
     * 时间复杂度：
     * 空间复杂度：
     */
    public int findKthLargestExample01(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        // 第K大 等价于 第pivot小
        int i = nums.length - k + 1;
        return quickSelect(0, nums.length - 1, i, nums);
    }

    /**
     * 方法二：使用堆来获取k个最大
     * 时间复杂度：
     * 空间复杂度：
     */
    public int findKthLargestExample02(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        // 建立最大堆
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            heap.offer(num);
        }
        // 删除k-1个堆顶元素
        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.peek();
    }

    /**
     * 手写堆排序
     */
    public int findKthLargestExample03(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        int heapSize = nums.length;
        // 建立最大堆
        buildMapHeap(nums);
        // 删除k-1个堆顶元素
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMapHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    private void maxHeapify(int[] nums, int index, int heapSize) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int largest = index;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }

        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != index) {
            swap(nums, index, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private int quickSelect(int start, int end, int k, int[] nums) {
        // base case
        if (start == end) {
            return nums[start];
        }

        int index = partition(nums, start, end);
        // 包括nums[index]
        int num = index - start + 1;
        if (k == num) {
            return nums[index];
        } else if (k < num) {
            return quickSelect(start, index - 1, k, nums);
        } else {
            return quickSelect(index + 1, end, k - num, nums);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // 左边部分
        int j = start - 1;
        for (int i = start; i <= end; i++) {
            // note：不能含有等号
            if (nums[i] < pivotValue) {
                j = j + 1;
                // 说明i之前一定有元素大于pivotValue，需要交换
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        // start ... j : x < value
        // j + 1 = value
        // j +2 ... end：x > value
        int temp = nums[end];
        nums[end] = nums[j + 1];
        nums[j + 1] = temp;
        return j + 1;
    }
}
