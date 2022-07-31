package com.mvp.learn.leetcode.solution.MergeKSortedLists;

import java.util.ArrayList;
import java.util.List;

/**
 * 23、合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 ：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    /**
     * 获取合并后的链表
     *
     * @param lists 有序链表数组列表
     * @param result 合并后的链表
     */
    public void mergeKLists(List<LinkedList> lists, LinkedList result) {
        int n = lists.size();
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            mergeTwoSortedLists(lists.get(i), lists.get(i + 1), result);
            lists.get(i + 1).getHead().next = result.getHead().next;
            result.getHead().next = null;
        }

        result.setHead(lists.get(n - 1).getHead());
    }

    private void mergeTwoSortedLists(LinkedList list1, LinkedList list2, LinkedList list3) {
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

        LinkedList list3 = new LinkedList();
        node = new ListNode(2);
        list3.addNode(node);
        node = new ListNode(6);
        list3.addNode(node);
        List<LinkedList> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        LinkedList result = new LinkedList();
        MergeKSortedLists obj = new MergeKSortedLists();
        obj.mergeKLists(lists, result);
        result.showNode();
    }
}