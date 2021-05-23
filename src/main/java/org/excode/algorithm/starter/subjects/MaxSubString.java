package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author iheng
 * @date 2021/5/23
 */
public class MaxSubString {
    public int lengthOfLongestSubstring(String s){
        int max= 0;

        Map<String, Integer> temp = new HashMap<>();

        int i = 0;
        while(i < s.length()){
            String c = Character.toString(s.charAt(i));
            if(!temp.containsKey(c)){
                temp.put(c, i);
                i++;
            }else{
                if(temp.keySet().size() > max){
                    max = temp.size();
                }

                int pre = temp.get(c);
                temp.clear();
                i  = pre +1;
            }
        }


        if(temp.size() > max){
            max = temp.size();
        }

        return max;
    }

    @Test
    public void testCase(){
        int result1 = lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, result1);

        int result2 = lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, result2);

        int result3 = lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, result3);

        int result4 = lengthOfLongestSubstring("dvdf");
        Assert.assertEquals(3, result4);
    }
}
