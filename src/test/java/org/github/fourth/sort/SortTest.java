package org.github.fourth.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("排序测试")
public class SortTest {

    @Test
    @DisplayName("quickSelect测试")
    public void quickSelectTest() {
        // arrange
        // {1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 10};
        int[] nums = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        // act
        QuickSelect quickSelect = new QuickSelect();
        int _1th = quickSelect.getKthSmallerElement(nums, 1);
        int _3th = quickSelect.getKthSmallerElement(nums, 3);
        int _5th = quickSelect.getKthSmallerElement(nums, 5);
        int _6th = quickSelect.getKthSmallerElement(nums, 6);
        int _9th = quickSelect.getKthSmallerElement(nums, 9);
        // assert
        Assertions.assertEquals(1, _1th);
        Assertions.assertEquals(3, _3th);
        Assertions.assertEquals(5, _5th);
        Assertions.assertEquals(5, _6th);
        Assertions.assertEquals(6, _9th);
    }

    @DisplayName("快速排序测试")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testQuickSort(int[] nums, int[] target) {
        // 快速排序1测试
        int[] quickSort1Nums = nums.clone();
        new QuickSort().sort(quickSort1Nums);
        Assertions.assertArrayEquals(quickSort1Nums, target);
        assertFalse(Arrays.equals(nums, target)); // 保证原生数组顺序未被打乱

        // 快速排序2测试
        int[] quickSort2Nums = nums.clone();
        new QuickSort().sort2(quickSort2Nums);
        Assertions.assertArrayEquals(quickSort2Nums, target);
        assertFalse(Arrays.equals(nums, target)); // 保证原生数组顺序未被打乱
    }

    @DisplayName("插入排序测试")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testInsertionSort(int[] nums, int[] target) {
        int[] insertionNums = nums.clone();
        new InsertionSort().sort(insertionNums);
        Assertions.assertArrayEquals(insertionNums, target);
        assertFalse(Arrays.equals(nums, target)); // 保证原生数组顺序未被打乱
    }

    @DisplayName("归并排序测试")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testMergeSort(int[] nums, int[] target) {
        // 归并排序1测试
        int[] mergeSort1Nums = nums.clone();
        new MergeSort().sort(mergeSort1Nums);
        Assertions.assertArrayEquals(mergeSort1Nums, target);
        assertFalse(Arrays.equals(nums, target)); // 保证原生数组顺序未被打乱

        // 归并排序2测试
        int[] mergeSort2Nums = nums.clone();
        new MergeSort().sort2(mergeSort2Nums);
        Assertions.assertArrayEquals(mergeSort2Nums, target);
        assertFalse(Arrays.equals(nums, target)); // 保证原生数组顺序未被打乱
    }

    @DisplayName("冒泡排序")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testBubbleSort(int[] nums, int[] target) {
        new BubbleSort().sort(nums);
        Assertions.assertArrayEquals(nums, target);
    }
    @DisplayName("优化版冒泡排序测试")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testBubbleBetterSort(int[] nums, int[] target) {
        int[] betterBubbleNums = nums.clone();
        new BubbleSort().betterSort(betterBubbleNums);
        Assertions.assertArrayEquals(betterBubbleNums, target);
        assertFalse(Arrays.equals(nums, target)); // 保证原生数组顺序未被打乱
    }

    public static Stream<Arguments> generateRightCase() {
        // case 1
        int[] beforeNums1 = new int[]{4, 3, 5, 6, 2, 1, 10, 8, 7, 6, 6, 5};
        int[] afterNums1 = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 10};

        // case 2
        int[] beforeNums2 = new int[]{4, 3, 5, 6, 2, 6, 6, 1, 10, 8, 7, 5};
        int[] afterNums2 = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 10};


        return Stream.of(
                arguments(beforeNums1, afterNums1),
                arguments(beforeNums2, afterNums2)
        );
    }
}
