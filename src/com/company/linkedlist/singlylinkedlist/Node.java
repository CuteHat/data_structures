package com.company.linkedlist.singlylinkedlist;

public class Node<T> {
    public T data;
    public Node<T> nextNode;

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
}