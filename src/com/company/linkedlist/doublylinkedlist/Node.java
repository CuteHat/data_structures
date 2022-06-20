package com.company.linkedlist.doublylinkedlist;

public class Node<T> {
    public T data;
    public Node<T> nextNode;
    public Node<T> prevNode;

    public Node(Node<T> prevNode, T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }
}
