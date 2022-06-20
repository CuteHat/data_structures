package com.company.linkedlist.doublylinkedlistwithtail;

public class Node<T> {
    public T data;
    public Node<T> nextNode;
    public Node<T> prevNode;

    public Node(Node<T> prevNode, T data, Node<T> nextNode) {
        this.prevNode = prevNode;
        this.data = data;
        this.nextNode = nextNode;
    }
}