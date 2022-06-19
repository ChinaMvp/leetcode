package com.mvp.learn.leetcode.solution.SwapNodesInPairs;

/**
 * 25.给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapNodesInPairs {

    public void swapPairs(LinkedList linkedList) {
        ListNode pre = linkedList.getHead();
        ListNode cur = pre.next;
        while ((cur != null) && (cur.next != null)) {
            // 交换当前节点和下一个节点
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = cur;
            pre.next = t;
            // 准备下一次迭代
            pre = cur;
            cur = cur.next;
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
        node = new ListNode(6);
        list1.addNode(node);

        list1.showNode();
        System.out.println();
        SwapNodesInPairs obj = new SwapNodesInPairs();
        obj.swapPairs(list1);
        list1.showNode();
    }
}
