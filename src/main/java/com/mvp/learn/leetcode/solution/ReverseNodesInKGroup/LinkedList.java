package com.mvp.learn.leetcode.solution.ReverseNodesInKGroup;

public class LinkedList {
    private ListNode head; // head 节点

    public LinkedList() {
        head = new ListNode(0);
        head.no = 0;
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
            System.out.print(temp.no + " ");
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

    // 迭代实现链表反转
    public void reversIterate() {
        // 链表为空或者链表只有一个节点的时候，不需要反转
        if (head.next == null || head.next.next == null) {
            System.out.println("链表无需反转!");
            return;
        }

        ListNode previewNode = null; // 前一个节点指针
        ListNode currentNode = head.next; // 当前节点指针
        ListNode nextNode; // 下一个节点指针
        while (currentNode != null) {
            nextNode = currentNode.next;  // 保存当前节点的next值
            currentNode.next = previewNode; // 当前节点的next值指向前一个节点
            previewNode = currentNode; // 前一个节点指针指向当前节点
            currentNode = nextNode; // 当前节点指针指向下一个节点
        }
        head.next = previewNode;
    }

    public void reverseRecurse() {
        head.next = reverseNodeRecurse(head.next);
    }

    // 递归实现链表反转
    public ListNode reverseNodeRecurse(ListNode currentNode) {
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }

        // 递归当前节点的下一个节点
        ListNode nextNode = reverseNodeRecurse(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return nextNode;
    }

    // 删除倒数第n个节点
    public boolean removeNthFromEnd(int n) {
        ListNode fast = head, slow = head;
        while (n > 0) {
            if (fast == null) {
                return false;
            }

            fast = fast.next;
            n--;
        }

        while ((fast != null) && (fast.next != null)) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return true;
    }

}
