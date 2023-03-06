package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/15.
 */
public class MyLinkedList {

    ListNode head;

    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0) return -1;
        ListNode dummy = head;
        // 因为dummy是目标的前驱结点，所以要找到目标结点，则需要多往后遍历一位，所以是i <= index
        for (int i = 0; i <= index; i++) {
            dummy = dummy.next;
        }
        return dummy.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        // 如果index 小于0则默认插入到首结点
        index = Math.max(0, index);
        // 更新链表长度
        size++;
        // 循环找到待插入的index, 注意:head指向的是链表中的第一个有效结点
        // dummy结点是目标结点的前驱结点，因为在有效结点前多增加了一个head结点
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        ListNode toBeAdded = new ListNode(val);
        toBeAdded.next = dummy.next;
        dummy.next = toBeAdded;
    }

    public void deleteAtIndex(int index) {
        // index == size的时候，会越界
        if (index >= size || index < 0) return;
        size--;
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
