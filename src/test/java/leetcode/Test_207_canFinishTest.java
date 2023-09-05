package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")

class Test_207_canFinishTest {
    private final Test_207_canFinish canFinish = new Test_207_canFinish();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int numCourses, int[][] prerequisites, boolean expectedResult) {
        boolean actResult = canFinish.canFinish(numCourses, prerequisites);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}