package com.mvp.learn.leetcode.solution.ReverseNodesInKGroup;

public class ListNode {
    int no;
    ListNode next;

    public ListNode(int no) {
        this.no = no;
    }

    public ListNode(int no, ListNode next) {
        this.no = no;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}