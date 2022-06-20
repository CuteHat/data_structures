package com.company.linkedlist.doublylinkedlist;

public class DoublyLinkedList<T> {
    public Node<T> head;
    public int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * custom constructors
     */
    public DoublyLinkedList(Node<T> head) {
        this.head = head;
        this.size = 1;
    }

    public DoublyLinkedList(T data) {
        this(new Node<>(null, data, null));
    }

    public void insertHead(T data) {
        Node<T> newHead = new Node<>(null, data, null);
        if (this.head != null) {
            this.head.prevNode = newHead;
        }
        this.head = newHead;
        size++;

    }


    public boolean searchNode(T data) {
        Node<T> node = this.head;
        while (node.nextNode != null) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    /**
     * Not tested
     */
    public void deleteHead() {
        if (isEmpty()) return;
        head = head.nextNode;
        head.prevNode = null;
        size--;
    }

    public void deleteNode(T data) {
        if (isEmpty()) return;
        if (!searchNode(data)) return;

        Node<T> currentNode = head;
        if (currentNode.data.equals(data)) {
            deleteHead();
            return;
        }

        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                Node<T> prevNode = currentNode.prevNode;
                Node<T> nextNode = currentNode.nextNode;

                prevNode.nextNode = nextNode;
                if (nextNode != null)
                    nextNode.prevNode = prevNode;
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }


    /**
     * we define isEmpty as head node pointing to null,
     * maybe checking size is better?
     */
    public boolean isEmpty() {
        return head == null;
    }
}
