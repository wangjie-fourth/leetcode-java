package leetcode;

import org.github.fourth.leetcode.LeetCode_240_searchMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("搜索二维矩阵 II")
public class LeetCode_240_searchMatrixTest {
    private final LeetCode_240_searchMatrix leetCode240SearchMatrix = new LeetCode_240_searchMatrix();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[][] matrix, int target, boolean expectedResult) {
        boolean actResult = leetCode240SearchMatrix.searchMatrix(matrix, target);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5, true),
                arguments(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 20, false)
        );
    }

}