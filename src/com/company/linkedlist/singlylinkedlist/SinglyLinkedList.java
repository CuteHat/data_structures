package com.company.linkedlist.singlylinkedlist;

public class SinglyLinkedList<T> {
    public Node<T> head;

    public int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * custom constructors
     */
    public SinglyLinkedList(Node<T> head) {
        this.head = head;
        this.size = 1;
    }

    public SinglyLinkedList(T data) {
        this(new Node<>(data, null));
    }

    public void insertHead(T data) {
        this.head = new Node<>(data, this.head);
        size++;
    }

    public void insertTail(T data) {
        if (isEmpty()) {
            insertHead(data);
            return;
        }

        Node<T> node = head;
        while (node.nextNode != null) {
            node = node.nextNode;
        }

        node.nextNode = new Node<>(data, null);
        size++;
    }

    public void insertAfter(T targetNodeData, T data) {
        Node<T> node = head;
        Node<T> targetNode = null;

        while (node.nextNode != null) {
            if (node.data == targetNodeData) {
                targetNode = node;
                break;
            }
            node = node.nextNode;
        }

        if (targetNode == null) return;

        targetNode.nextNode = new Node<>(data, targetNode.nextNode);
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
        if (head == null)
            return;

        head = head.nextNode;
        size--;
    }

    public void deleteNode(T data) {
        if (isEmpty()) return;
        if (!searchNode(data)) return;

        Node<T> currentNode = head;
        Node<T> prevNode = null;

        if (currentNode.data.equals(data)) {
            deleteHead();
            return;
        }

        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                prevNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }


        size--;
    }

    public int length() {
        int count = 0;

        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.nextNode;
        }
        return count;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node<T> temp = head;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    /**
     * we define isEmpty as head node pointing to null,
     * maybe checking size is better?
     */
    public boolean isEmpty() {
        return head == null;
    }
}
