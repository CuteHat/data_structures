package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;
import com.company.linkedlist.singlylinkedlist.Node;

/**
 * In this problem, you have to implement the public static <T> void reverse(SinglyLinkedList<T> list) method,
 * which will take a linked list as input and reverse its content.
 * An illustration is also provided for your help to see how the linked list will look after passing it to your function.
 */
public class ReverseSLL {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sLL = new SinglyLinkedList<>();
        sLL.insertHead(10);
        sLL.insertAtEnd(9);
        sLL.insertAtEnd(4);
        sLL.insertAtEnd(6);
        sLL.printList();
        reverse(sLL);
        sLL.printList();
    }

    public static <T> void reverse(SinglyLinkedList<T> list) {
        Node<T> nextNode = list.headNode;
        Node<T> prevNode = null;

        while (nextNode != null) {
            Node<T> currentNode = nextNode;
            nextNode = nextNode.nextNode;

            currentNode.nextNode = prevNode;
            prevNode = currentNode;
        }

        list.headNode = prevNode;
    }
}
