package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-21 23:04
 *
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。题目保证链表中节点的值互不相同
 *
 * 示例 1:
 *      输入: head = [4,5,1,9], val = 5
 *      输出: [4,1,9]
 *      解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteNode(ListNode head, int val) {
        //非空判断
        if(head == null){
            return null;
        }
        //判断头节点是不是要被删除的节点
        if(head.val == val){
            return head.next;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null && curr.val != val){
            prev = curr;
            curr = curr.next;
        }
        //curr == null 表示：遍历完没有找到被删除的节点
        if(curr != null){
            //找到了被删除的节点
            prev.next = curr.next;
        }
        return head;
    }
}
