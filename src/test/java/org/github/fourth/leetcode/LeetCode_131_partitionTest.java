package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("分割回文串")
class LeetCode_131_partitionTest {

    private final LeetCode_131_partition partition = new LeetCode_131_partition();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, List<List<String>> expectedResult) {
        List<List<String>> actResult = partition.partition01(s);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(String s, List<List<String>> expectedResult) {
        List<List<String>> actResult = partition.partitionExample(s);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("aab", List.of(List.of("a", "a", "b"), List.of("aa", "b"))),
                arguments("a", List.of(List.of("a")))
        );
    }
}