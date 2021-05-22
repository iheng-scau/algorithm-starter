package org.excode.algorithm.starter.subjects;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author iheng
 * @date 2021/5/22
 */
public class Addition {

    /**
     * solution
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode next = result;

        int add = 0;
        int val;
        while (true) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int r = v1 + v2 + add;
            if (r >= 10) {
                val = r % 10;
                add = 1;
            } else {
                val = r;
                add = 0;
            }

            next.val = val;

            if (l1 == null || l1.next == null) {
                l1 = null;
            } else {
                l1 = l1.next;
            }

            if (l2 == null || l2.next == null) {
                l2 = null;
            } else {
                l2 = l2.next;
            }

            if (l1 == null && l2 == null && add ==0) {
                break;
            }

            next.next = new ListNode();
            next = next.next;
        }

        return result;
    }

    /*********************************** data structure ***********************************/
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*********************************** test ***********************************/
    @Test
    public void testCase() {
        Addition addition = new Addition();
        ListNode l1 = addition.buildListNode("465");
        ListNode l2 = addition.buildListNode("1000000000000000000000000000001");

        ListNode result = addition.addTwoNumbers(l1, l2);

        String actual = listNodeToString(result);
        Assert.assertEquals("[6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]", actual);
    }

    private ListNode buildListNode(String value) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (int i = value.length() - 1; i >= 0; i--) {
            temp.val = value.charAt(i) - '0';
            if (i != 0) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return listNode;
    }

    private String listNodeToString(ListNode listNode){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode temp = listNode;
        while (true){
            sb.append(temp.val);
            temp = temp.next;
            if(temp == null){
                sb.append("]");
                break;
            }
            sb.append(",");
        }
        return sb.toString();
    }

    /*********************************** deprecated ***********************************/
    @Deprecated
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long v1 = getActualValue(l1);
        long v2 = getActualValue(l2);

        long result = v1 + v2;

        return buildListNode1(result);
    }

    @Deprecated
    private long getActualValue(ListNode listNode) {
        long value = 0;
        long bitCount = 0;

        while (listNode != null) {
            value += listNode.val * Math.pow(10, bitCount);
            listNode = listNode.next;
            bitCount++;
        }
        return value;
    }

    @Deprecated
    private ListNode buildListNode1(long value) {
        String str = String.valueOf(value);

        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (int i = str.length() - 1; i >= 0; i--) {
            temp.val = str.charAt(i) - '0';
            if (i != 0) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return listNode;
    }
}
