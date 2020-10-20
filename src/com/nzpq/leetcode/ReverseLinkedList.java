package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-20 13:20
 *
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 *
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class ReverseLinkedList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 反转单链表
     * @param head 反转前
     * @return 反转后
     */
    public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;//将curr下一个节点存起来，
            curr.next = prev;
            //让prev和curr向前移动一个节点
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
