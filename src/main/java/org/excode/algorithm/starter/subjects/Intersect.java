package org.excode.algorithm.starter.subjects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iheng
 * @date 2021/6/4
 */
public class Intersect {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> reg = new ArrayList<>();

        if(headA == null || headB == null){
            return null;
        }

        while(headA!=null){
            reg.add(headA);
            headA = headA.next;
        }

        while(headB!= null){
            if(reg.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    @Test
    public void test(){

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
