package com.mvp.learn.leetcode.solution.TwoLinkedNodeValueSum;

/**
 * 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class TwoLinkedNumberSum {

    public void addTwoNumbers(LinkedList list1, LinkedList list2, LinkedList list3) {
        ListNode l1 = list1.getHead().next;
        ListNode l2 = list2.getHead().next;

        int value1 = 0;
        int value2 = 0;
        int valueSum = 0;
        int value3 = 0;
        int carry = 0;
        ListNode currentNode = list3.getHead();
        while (l1 != null || l2 != null || carry != 0) {
            value1 = l1 == null ? 0 : l1.val;
            value2 = l2 == null ? 0 : l2.val;
            valueSum = value1 + value2 + carry; // 同一位上各数字的和
            value3 = valueSum % 10; // 同一位上各数加和的结果值
            carry = valueSum / 10; // 进位值
            currentNode.next = new ListNode(value3);
            currentNode = currentNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        list1.addNode(n1);
        list1.addNode(n2);
        list1.addNode(n3);
        list1.addNode(n4);
        list1.addNode(n5);

        LinkedList list2 = new LinkedList();
        ListNode n12 = new ListNode(1);
        ListNode n22 = new ListNode(2);
        ListNode n32 = new ListNode(3);
        ListNode n42 = new ListNode(4);
        ListNode n52 = new ListNode(5);
        list2.addNode(n12);
        list2.addNode(n22);
        list2.addNode(n32);
        list2.addNode(n42);
        list2.addNode(n52);

        LinkedList list3 = new LinkedList();

        TwoLinkedNumberSum obj = new TwoLinkedNumberSum();
        obj.addTwoNumbers(list1, list2, list3);
        list3.showNode();
    }
}
