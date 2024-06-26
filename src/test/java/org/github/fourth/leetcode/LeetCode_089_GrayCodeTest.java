package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("格雷编码")
public class LeetCode_089_GrayCodeTest {
    private final LeetCode_089_GrayCode leetCode089GrayCode = new LeetCode_089_GrayCode();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int n, List<Integer> expectedResult) {
        List<Integer> actResult = leetCode089GrayCode.grayCode01(n);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int n, List<Integer> expectedResult) {
        List<Integer> actResult = leetCode089GrayCode.grayCodeExample(n);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(2, List.of(0, 1, 3, 2)),
                arguments(1, List.of(0, 1))
        );
    }


}
