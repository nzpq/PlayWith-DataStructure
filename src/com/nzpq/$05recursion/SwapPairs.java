package com.nzpq.$05recursion;

/**
 * @author 鹏
 * @date 2020-10-24 13:21
 *
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例
 *  输入：head = [1,2,3,4]
 *  输出：[2,1,4,3]
 *
 *  https://leetcode-cn.com/leetbook/read/recursion/4p9kt/
 */
public class SwapPairs {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     *
     * @param head 链表头节点
     * @return 返回交换节点后的新的头节点
     */
    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode res = head.next; //找到交换节点的下一个
        ListNode temp = swapPairs(head.next.next);  //需要移动头部
        res.next = head; //交换
        head.next = temp; //头部移动到下一组

        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        swapPairs(node1);

    }
}
