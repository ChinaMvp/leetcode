package com.mvp.learn.leetcode.solution.LinkedListReverse;

/**
 * 链表反转
 */
public class ListNodeReverse {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // 创建并添加数值节点
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        linkedList.addNode(n1);
        linkedList.addNode(n2);
        linkedList.addNode(n3);
        linkedList.addNode(n4);
        linkedList.addNode(n5);

        System.out.println("反转之前:");
        linkedList.showNode();
        System.out.println();

        System.out.println("迭代反转之后:");
        linkedList.reversIterate();
        linkedList.showNode();
        System.out.println();

        System.out.println("再次递归反转:");
        linkedList.reverseRecurse();
        linkedList.showNode();
    }
}

