package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("用队列实现栈")
public class LeetCode_225_MyStackTest {

    @Test
    public void test() {
        LeetCode_225_MyStack myStack = new LeetCode_225_MyStack();
        myStack.push(1);
        myStack.push(2);
        Assertions.assertEquals(2, myStack.top()); // 返回 2
        Assertions.assertEquals(2, myStack.pop()); // 返回 2
        Assertions.assertFalse(myStack.empty()); // 返回 False
    }
}
