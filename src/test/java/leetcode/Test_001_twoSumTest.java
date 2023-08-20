package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("俩数之和测试数据")
public class Test_001_twoSumTest {

    private final Test_001_twoSum test001TwoSum = new Test_001_twoSum();

    @DisplayName("成功测试用例")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int[] nums, int target, int[] expectedResults) {
        int[] actResult = test001TwoSum.twoSum(nums, target);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        Assertions.assertEquals(2, actResult.length);
        if (expectedResults[0] == actResult[0]) {
            Assertions.assertEquals(expectedResults[1], actResult[1]);
        } else {
            Assertions.assertEquals(expectedResults[0], actResult[1]);
            Assertions.assertEquals(expectedResults[1], actResult[0]);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1})

        );
    }
}
