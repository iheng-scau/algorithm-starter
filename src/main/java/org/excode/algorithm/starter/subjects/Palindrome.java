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
        int i = 0;
        while(i< s.length()) {
            if((i+1 > s.length()-1)){
                if(s.charAt(i) == s.charAt(i-1<0?i:i-1))
                    palindrome = tmp + s.charAt(i);
                break;
            }
            int j, k;
            if(s.charAt(i) == s.charAt(i+1)){
                j = i;
                k = i+1;
            }else {
                j= i-1;
                k= i+1;
            }
            while (true) {
                if (j < 0 || k > s.length() - 1) {
                    i++;
                    break;
                }

                if (s.charAt(j) == s.charAt(k)) {
                    tmp = s.substring(j,k+1);
                    j--;
                    k++;
                } else {
                    i = k+1;
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
        String result = palindrome.longestPalindrome("babad");

        Assert.assertEquals("bab", result);

        result = palindrome.longestPalindrome("cbbd");
        Assert.assertEquals("bb", result);

        result = palindrome.longestPalindrome("ac");
        Assert.assertEquals("a", result);

        result = palindrome.longestPalindrome("bb");
        Assert.assertEquals("bb", result);
    }
}
