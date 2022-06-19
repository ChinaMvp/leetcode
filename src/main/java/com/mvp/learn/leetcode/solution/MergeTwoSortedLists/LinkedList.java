package com.mvp.learn.leetcode.solution.MergeTwoSortedLists;


public class LinkedList {
    private ListNode head; // head 节点

    public LinkedList() {
        head = new ListNode(0);
        head.val = 0;
        head.next = null;
    }

    public ListNode getHead() {
        return head;
    }

    // 显示链表
    public void showNode() {
        if (head.next == null) {
            System.out.println("链表为空!");
            return;
        }

        ListNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    // 添加元素
    public void addNode(ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }
}
