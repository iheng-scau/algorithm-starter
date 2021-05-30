package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author iheng
 * @date 2021/5/30
 */
public class PowerTwo {
    public boolean isPowerOfTwo(int n) {
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
        Assert.assertTrue(result);

        result = powerTwo.isPowerOfTwo(3);
        Assert.assertFalse(result);

        result = powerTwo.isPowerOfTwo(4);
        Assert.assertTrue(result);

        result = powerTwo.isPowerOfTwo(0);
        Assert.assertFalse(result);
    }
}
