package com.company.linkedlist.singlylinkedlist;

import java.util.HashSet;

public class SinglyLinkedList<T> {
    public Node<T> headNode;

    public int size;

    public SinglyLinkedList() {
        this.headNode = null;
        this.size = 0;
    }

    /**
     * custom constructors
     */
    public SinglyLinkedList(Node<T> headNode) {
        this.headNode = headNode;
        this.size = 1;
    }

    public SinglyLinkedList(T data) {
        this(new Node<>(data, null));
    }

    public void insertHead(T data) {
        this.headNode = new Node<>(data, this.headNode);
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertHead(data);
            return;
        }

        Node<T> node = headNode;
        while (node.nextNode != null) {
            node = node.nextNode;
        }

        node.nextNode = new Node<>(data, null);
        size++;
    }

    public void insertAfter(T targetNodeData, T data) {
        Node<T> node = headNode;
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
        Node<T> node = this.headNode;
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
        if (headNode == null)
            return;

        headNode = headNode.nextNode;
        size--;
    }

    public void deleteNode(T data) {
        if (isEmpty()) return;
        if (!searchNode(data)) return;

        Node<T> currentNode = headNode;
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

        Node<T> current = headNode;
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

        Node<T> temp = headNode;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    public void removeDuplicatesWithHashing() {
        Node<T> current = this.headNode;
        Node<T> prevNode = this.headNode;
        //will store all the elements that we observe once
        HashSet<T> visitedNodes = new HashSet<T>();

        if (!isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
    }

    /**
     * we define isEmpty as head node pointing to null,
     * maybe checking size is better?
     */
    public boolean isEmpty() {
        return headNode == null;
    }
}
