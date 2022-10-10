package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/08/23.
 */
public class LRUCache {

    private DListNode tail;

    private DListNode head;

    public LRUCache() {
        this.head = new DListNode();
        this.tail = new DListNode();
    }

    static class DListNode {
        private DListNode pre, next;
        private int size;
        private DListNode tail, head;

        public DListNode(DListNode pre, DListNode next) {
            this.pre = pre;
            this.next = next;
            this.size = 0;
        }

        public DListNode() {
        }

        void keepThisNewest(DListNode curNode) {
            remove(curNode);
            addLast(curNode);
        }

        void addLast(DListNode curNode) {

        }

        void remove(DListNode cur) {
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;
            cur.pre = null;
            cur.next = null;
            size--;
        }
    }
}
