package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")

class Test_188_maxProfitTest {
    private final Test_188_maxProfit maxProfit = new Test_188_maxProfit();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(int k, int[] prices,int expectedResult) {
        int actResult = maxProfit.maxProfit(k, prices);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}