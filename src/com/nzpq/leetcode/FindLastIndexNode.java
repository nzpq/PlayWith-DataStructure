package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-20 9:21
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 *  给定一个链表: 1->2->3->4->5, 和 k = 2.
 *  返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLastIndexNode {

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    /**
     * 双指针法 链表中倒数第k个节点
     * 题解：第一个指针先移动k步，然后第二个指针指向head，让这两个指针同时移动，当第一个指针移动到链表最后为null时，返回第二个指针即可
     *
     * @param head 被查找的链表
     * @param k 倒数第k的节点
     * @return 结果
     */
    private ListNode getKthFromEnd(ListNode head,int k){
        //让第一个指针移动k步
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        //让这两个指针同时移动，直到第一个指针移动到最后一个元素
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
