import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("奇偶排序测试")
public class SortArrayByParityTest {

    @DisplayName("奇偶排序测试")
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, int pos, int[] expectedResults) {
        int[] actResult = new SortArrayByParity().sortArrayByParity(nums);
        Assertions.assertEquals(expectedResults.length, actResult.length);
        for (int i = 0; i < pos; i++) {
            Assertions.assertEquals(0, actResult[i] % 2);
        }
        for (int i = pos; i < nums.length; i++) {
            Assertions.assertEquals(1, actResult[i] % 2);
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{3,1,2,4}, 2,  new int[]{4,2,3,1}),
                arguments(new int[]{0, 1, 2}, 2,  new int[]{0, 2, 1}),
                arguments(new int[]{0}, 1, new int[]{0})
        );
    }

}
