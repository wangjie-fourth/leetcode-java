package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("柱状图中最大的矩形")
public class LeetCode_084_largestRectangleAreaTest {

    private final LeetCode_084_largestRectangleArea largestRectangleArea = new LeetCode_084_largestRectangleArea();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] heights, int expectedResult) {
        commonTest(expectedResult, x -> x.largestRectangleArea01(heights));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(int[] heights, int expectedResult) {
        commonTest(expectedResult, x -> x.largestRectangleArea02(heights));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(int[] heights, int expectedResult) {
        commonTest(expectedResult, x -> x.largestRectangleArea03(heights));
    }

    private void commonTest(int expectedResult, Function<LeetCode_084_largestRectangleArea, Integer> function) {
        int actResult = function.apply(largestRectangleArea);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 1, 5, 6, 2, 3}, 10),
                arguments(new int[]{1, 1, 1, 1, 1, 1}, 6),
                arguments(new int[]{1, 2, 2, 2, 2, 2}, 10),
                arguments(new int[]{0}, 0),
                arguments(new int[]{2, 4}, 4)
        );
    }

}
