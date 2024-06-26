package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("存在重复元素 II")
class LeetCode_219_containsNearbyDuplicateTest {
    private final LeetCode_219_containsNearbyDuplicate containsNearbyDuplicate = new LeetCode_219_containsNearbyDuplicate();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int k, boolean expectedResult) {
        boolean actResult = containsNearbyDuplicate.containsNearbyDuplicate01(nums, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] nums, int k, boolean expectedResult) {
        boolean actResult = containsNearbyDuplicate.containsNearbyDuplicateExample(nums, k);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, 3, true),
                arguments(new int[]{1, 0, 1, 1}, 1, true),
                arguments(new int[]{1, 2, 3, 1, 2, 3}, 2, false)
        );
    }
}