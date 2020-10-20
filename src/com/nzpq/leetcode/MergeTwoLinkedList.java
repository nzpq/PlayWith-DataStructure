package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-20 14:14
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class MergeTwoLinkedList {

     private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 合并两个排序的链表，合并后的链表仍然有序
     * 使用虚拟头节点
     * @param l1 合并前的链表1
     * @param l2 合并前的链表2
     * @return 合并后的链表
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //虚拟头节点，指向合并后链表的头，主要作用就是第一次循环时，将节点添加到合并后的链表
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        //遍历链表，结束的条件就是当其中有一个链表遍历完毕
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            //curr后移
            curr = curr.next;
        }
        //当其中一个链表遍历完毕但是另一个链表还有节点的时候
        curr.next = l1 != null ? l1 : l2;

        return dummyHead.next;
    }
}
