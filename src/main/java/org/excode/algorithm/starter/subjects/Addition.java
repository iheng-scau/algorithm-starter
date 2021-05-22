package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author iheng
 * @date 2021/5/22
 */
public class Addition {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        long v1 = getActualValue(l1);
        long v2 = getActualValue(l2);

        long result = v1 + v2;

        return buildListNode(result);
    }

    private long getActualValue(ListNode listNode){
        long value = 0;
        long bitCount = 0;

        while(listNode!=null){
            value += listNode.val*Math.pow(10,bitCount);
            listNode = listNode.next;
            bitCount++;
        }
        return value;
    }

    private ListNode buildListNode(long value){
        String str = String.valueOf(value);

        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for(int i = str.length()-1; i>=0;i--) {
            temp.val = str.charAt(i)-'0';
            if(i!=0) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return listNode;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode (int val) {
            this.val = val;
        }

        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void testCase() {
        Addition addition = new Addition();
        ListNode l1 = addition.buildListNode(465);
        ListNode l2 = addition.buildListNode(1000000000000000l);

        ListNode result = addition.addTwoNumbers(l1, l2);

        long actual = getActualValue(result);
        Assert.assertEquals(10000000000l,  actual);
    }
}
