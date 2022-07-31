package com.mvp.learn.leetcode.solution.TwoLinkedNodeValueSum;

/**
 * 2、两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class TwoLinkedNumberSum {

    /**
     * 两链表数字相加
     *
     * @param list1 列表1
     * @param list2 列表2
     * @param list3 结果列表
     */
    public void addTwoNumbers(LinkedList list1, LinkedList list2, LinkedList list3) {
        ListNode l1 = list1.getHead().next;
        ListNode l2 = list2.getHead().next;

        int value1, value2, valueSum;
        int value3;
        int carry = 0;
        ListNode currentNode = list3.getHead();
        while ((l1 != null) || (l2 != null) || (carry != 0)) {
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
        ListNode node = new ListNode(1);
        list1.addNode(node);
        node = new ListNode(2);
        list1.addNode(node);
        node = new ListNode(3);
        list1.addNode(node);
        node = new ListNode(4);
        list1.addNode(node);
        node = new ListNode(5);
        list1.addNode(node);

        LinkedList list2 = new LinkedList();
        node = new ListNode(1);
        list2.addNode(node);
        node = new ListNode(2);
        list2.addNode(node);
        node = new ListNode(3);
        list2.addNode(node);
        node = new ListNode(4);
        list2.addNode(node);
        node = new ListNode(5);
        list2.addNode(node);

        LinkedList list3 = new LinkedList();
        TwoLinkedNumberSum obj = new TwoLinkedNumberSum();
        obj.addTwoNumbers(list1, list2, list3);
        list3.showNode();
    }
}
