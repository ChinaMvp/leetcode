package com.mvp.learn.leetcode.solution.RemoveNthNodeFromEnd;

public class ListNode {
    public int no;
    public ListNode next;

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