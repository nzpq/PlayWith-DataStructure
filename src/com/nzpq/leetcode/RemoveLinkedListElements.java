package com.nzpq.leetcode;

/**
 * @author 鹏
 * @Date 2020-10-18 20:48
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *      输入: 1->2->6->3->4->5->6, val = 6
 *      输出: 1->2->3->4->5
 *
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
           StringBuilder sb = new StringBuilder();
           ListNode curr = this;
           while(curr != null){
               sb.append(curr.val).append(" --> ");
               curr = curr.next;
           }
           sb.append(" NULL ");
           return sb.toString();
        }
    }

    /**
     * 递归删除
     * @param head 链表
     * @param val 被移除的元素
     * @return 移除节点后的链表
     */
    public static ListNode removeElements3(ListNode head,int val){
        //链表非空判断
        if(head == null){
            return null;
        }
        //
        head.next = removeElements3(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
    
    
    /**
     * 移除链表listNode中的所有节点val
     * @param head 链表
     * @param val 被移除的元素
     * @return 移除节点后的链表
     */
  public static ListNode removeElements(ListNode head,int val){

      //如果头节点就是被删除节点，先判断链表是否为空
      while(head != null && head.val == val){
          ListNode delNode = head;
          head = head.next; //头节点后移
          delNode.next = null;
      }
      //如果链表中的所有节点都是被删除的节点，那么上个循环执行完毕后，链表就是null
      if(head == null){
          return null;
      }
      //被移除的元素在链表中间的位置
      ListNode prev = head; //辅助遍历，定位到被删除节点的上一个节点位置
      while(prev.next != null){
          if(prev.next.val == val){
              //找到了要被删除的节点
              ListNode delNode = prev.next;
              prev.next = delNode.next;
              delNode.next = null;
              //删除完后，prev节点不能后移，因为下一个节点也可能是要被删除的节点
          }else{
              prev = prev.next;
          }
      }
      return head;
  }

    /**
     * 移除链表listNode中的所有节点val，使用虚拟头节点
     * @param head 链表
     * @param val 被移除的元素
     * @return 移除节点后的链表
     */
    public static ListNode removeElements2(ListNode head,int val){

        //创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //被移除的元素在链表中间的位置
        ListNode prev = dummyHead; //辅助遍历，定位到被删除节点的上一个节点位置
        while(prev.next != null){
            if(prev.next.val == val){
                //找到了要被删除的节点
                prev.next = prev.next.next;
                //删除完后，prev节点不能后移，因为下一个节点也可能是要被删除的节点
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(2);
        ListNode list6 = new ListNode(6);
        ListNode list7 = new ListNode(2);
        ListNode list8 = new ListNode(8);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        list7.next = list8;

        System.out.println(list1);

        ListNode head = removeElements3(list1,2);

        System.out.println(head);

    }
}
