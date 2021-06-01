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
        if(s == null || s.length() < 1){
            return "";
        }

        int start =0;
        int end =0;

        for(int i=0; i<s.length(); i++){
            int l1= findPalindrome(s, i, i);
            int l2= findPalindrome(s, i, i+1);

            int length = Math.max(l1,l2);

            if(length > end -start){
                start = i -(length-1)/2;
                end = i+length/2;
            }
        }

        return  s.substring(start, end+1);
    }

    public int findPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        return  right - left-1;
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
