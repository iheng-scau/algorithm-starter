package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author iheng
 * @date 2021/5/25
 */
public class Palindrome {
    public String longestPalindrome(String s) {
        String palindrome = s.substring(0,1);

        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            int j = i-1, k = i+1;
            while (true) {
                if (j < 0 || k > s.length() - 1) {
                    break;
                }

                if (s.charAt(j) == s.charAt(k)) {
                    tmp = s.substring(j,k+1);
                    j--;
                    k++;
                } else {
                   break;
                }
            }

            if(tmp.length()>palindrome.length()){
                palindrome = tmp;
            }
        }
        return palindrome;
    }

    @Test
    public void test(){
        Palindrome palindrome = new Palindrome();
        String result = palindrome.longestPalindrome("babab");

        Assert.assertEquals("bab", result);
    }
}
