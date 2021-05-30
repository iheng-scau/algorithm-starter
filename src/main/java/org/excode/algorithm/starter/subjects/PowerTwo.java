package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author iheng
 * @date 2021/5/30
 */
public class PowerTwo {

    /**
     * 一行简洁, 利用2的n次方的二进制特性进行
     * n & n-1 按位&的结果为0
     * 一定的, 2^n只有在第k位为1其他位为0
     * 而n-1的[k-1,1]位都为0
     * 另外的思路是
     * 1.  n &(-n) =n
     * 2.  2^3mod n ==0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) ==0;
    }

    /**
     *  循环取mod的方式判定
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        int mod;

        if(n==1){
            return true;
        }

        if(n<=0){
            return false;
        }

        while (n >1) {
            mod = n % 2;
            if (mod == 0) {
                n = n / 2;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        PowerTwo powerTwo = new PowerTwo();
        boolean result = powerTwo.isPowerOfTwo(1);
        Assert.assertTrue(result);

        result = powerTwo.isPowerOfTwo(-16);
        Assert.assertFalse(result);

        result = powerTwo.isPowerOfTwo(3);
        Assert.assertFalse(result);

        result = powerTwo.isPowerOfTwo(4);
        Assert.assertTrue(result);

        result = powerTwo.isPowerOfTwo(0);
        Assert.assertFalse(result);
    }
}
