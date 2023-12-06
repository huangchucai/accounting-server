package com.hcc.accounting.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * mockito 的使用4大步
 * 1. 创建模拟对象  -> 使用mockito创建模拟对象代替真实的依赖
 * 2. 设定预期行为  -> 设置模拟对象在某些调用下的预期行为（如特定的返回值）
 * 3. 在测试中使用模拟对象 -> 测试中使用这些模拟对象并观察反应
 * 4. 验证结果
 */
public class DemoTest {
    @Test
    void testList(){
        List<String> mockList = mock();

        when(mockList.get(5)).thenReturn("five");

        // 不会调用真正的方法，适合有副作用的情况
        doReturn("One").when(mockList).get(1);
        doThrow(new IndexOutOfBoundsException("out of bounds")).when(mockList).get(2);

        System.out.println(mockList.get(5));
//        System.out.println(mockList.get(2));
        System.out.println(mockList.get(1));

        // 验证模拟对象方法调用次数
        verify(mockList, never()).get(eq(3));
        verify(mockList, atLeastOnce()).get(eq(5));
//        verify(mockList).get(0);
        verify(mockList, times(2)).get(anyInt());
    }
}
