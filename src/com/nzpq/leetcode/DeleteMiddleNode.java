package com.nzpq.leetcode;

/**
 * @author 鹏
 * @date 2020-10-31 10:34
 *
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class DeleteMiddleNode {

    private void deleteNode(ListNode node) {
        //因为被删除的是node
        //让node.next节点的值赋值给node，然后删除node.next即可
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
}
