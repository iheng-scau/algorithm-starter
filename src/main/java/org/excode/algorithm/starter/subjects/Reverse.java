package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-integer/submissions/
 * @author iheng
 * @date 2021/5/23
 */
public class Reverse {
    public int reverse(int x){
        int result = 0;
        while(x!=0){
            if(result >0 && result > (Integer.MAX_VALUE-x%10)/10) return  0;
            if(result <0 && result < (Integer.MIN_VALUE-x%10)/10) return  0;

            result = result*10 + x%10;
            x = x/10;
        }
        return result;
    }

    @Test
    public void testReverse(){
        Reverse reverse = new Reverse();
        int actual = reverse.reverse(123);
        Assert.assertEquals(321, actual);

        actual = reverse.reverse(-123);
        Assert.assertEquals(-321, actual);

        actual = reverse.reverse(120);
        Assert.assertEquals(21, actual);

        actual = reverse.reverse(1534236469);
        Assert.assertEquals(0, actual);
    }
}
