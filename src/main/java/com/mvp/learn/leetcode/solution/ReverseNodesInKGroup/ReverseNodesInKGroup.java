package com.mvp.learn.leetcode.solution.ReverseNodesInKGroup;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseNodesInKGroup {

    public void reverseKGroup(LinkedList linkedList, int k) {
        if (k < 2) {
            System.out.println("k < 2, please check! k=" + k);
            return;
        }

        ListNode head = linkedList.getHead();
        ListNode pre = head, cur = head;
        while ((cur != null) && (cur.next != null)) {
            for (int i = 0; (i < k) && (cur != null); ++i) {
                cur = cur.next;
            }
            if (cur == null) {
                return;
            }

            // 进行当前组内节点反转
            ListNode start = pre.next;
            ListNode t = cur.next;
            cur.next = null;
            pre.next = reverseList(start);
            start.next = t;
            // 准备下一轮迭代
            pre = start;
            cur = start;
        }
    }

    private ListNode reverseList(ListNode first) {
        ListNode pre = null, p = first;
        ListNode q;
        while (p != null) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
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
        node = new ListNode(7);
        list1.addNode(node);
        node = new ListNode(8);
        list1.addNode(node);
        list1.showNode();
        System.out.println();

        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        int n = 3;
        obj.reverseKGroup(list1, n);
        list1.showNode();
    }
}