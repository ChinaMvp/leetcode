package com.mvp.learn.leetcode.solution.MergeTwoSortedLists;

/**
 * 21、合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {

    public void mergeTwoSortedLists(LinkedList list1, LinkedList list2, LinkedList list3) {
        ListNode l1 = list1.getHead().next;
        ListNode l2 = list2.getHead().next;
        ListNode currentNode = list3.getHead();
        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = l1 == null ? l2 : l1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        ListNode node = new ListNode(1);
        list1.addNode(node);
        node = new ListNode(2);
        list1.addNode(node);
        node = new ListNode(4);
        list1.addNode(node);
        node = new ListNode(5);
        list1.addNode(node);

        LinkedList list2 = new LinkedList();
        node = new ListNode(1);
        list2.addNode(node);
        node = new ListNode(3);
        list2.addNode(node);
        node = new ListNode(4);
        list2.addNode(node);
        node = new ListNode(5);
        list2.addNode(node);

        LinkedList list3 = new LinkedList();
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        obj.mergeTwoSortedLists(list1, list2, list3);
        list3.showNode();
    }
}
