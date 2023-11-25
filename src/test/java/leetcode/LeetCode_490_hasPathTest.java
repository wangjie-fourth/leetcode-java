package leetcode;

import org.github.fourth.leetcode.LeetCode_490_hasPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("490. 迷宫")
class LeetCode_490_hasPathTest {
    private final LeetCode_490_hasPath hasPath = new LeetCode_490_hasPath();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] maze, int[] start, int[] destination, boolean expectedResult) {
        boolean actResult = hasPath.hasPath(maze, start, destination);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                }, new int[]{0, 4}, new int[]{4, 4}, true),
                arguments(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                }, new int[]{0, 4}, new int[]{3, 2}, false),
                arguments(new int[][]{
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {0, 1, 0, 0, 0}
                }, new int[]{4, 3}, new int[]{0, 1}, false)
        );
    }
}