package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("不同路径")
class LeetCode_062_uniquePathsTest {

    private final LeetCode_062_uniquePaths uniquePaths = new LeetCode_062_uniquePaths();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int m, int n, int expectedResult) {
        int actResult = uniquePaths.uniquePaths01(m, n);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(3, 7, 28),
                arguments(3, 2, 3),
                arguments(7, 3, 28),
                arguments(3, 3, 6)
        );
    }
}