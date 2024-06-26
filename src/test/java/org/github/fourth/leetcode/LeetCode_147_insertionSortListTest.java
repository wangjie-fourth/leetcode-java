package org.github.fourth.leetcode;

import org.github.fourth.ListNodeVerifyUtil;
import org.github.fourth.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("对链表进行插入排序")
class LeetCode_147_insertionSortListTest {
    private final LeetCode_147_insertionSortList insertionSortList = new LeetCode_147_insertionSortList();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(ListNode head, ListNode expectedResult) {
        ListNode actResult = insertionSortList.insertionSortList01(head);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(ListNode head, ListNode expectedResult) {
        ListNode actResult = insertionSortList.insertionSortListExample(head);
        Assertions.assertTrue(ListNodeVerifyUtil.equals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(ListNode.build(4, 2, 1, 3), ListNode.build(1, 2, 3, 4)),
                arguments(ListNode.build(-1, 5, 3, 4, 0), ListNode.build(-1, 0, 3, 4, 5))
        );
    }
}