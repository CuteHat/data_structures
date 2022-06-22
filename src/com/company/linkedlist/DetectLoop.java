package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.Node;
import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * In this problem, you have to implement the public static <T> boolean detectLoop(SinglyLinkedList<T> list) method,
 * which will take a Singly linked list as input and find if there is a loop present in the list.
 * A loop in a linked list occurs if any node contains a reference to any previous node,
 * then a loop will be formed. An illustration is also provided for your understanding.
 */
public class DetectLoop {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sLL = LinkedListUtil.getSll("7->14->21->7");
        SinglyLinkedList<Integer> sLL2 = LinkedListUtil.getSll("7->14->21");

//        System.out.println(detectLoop(sLL));
//        System.out.println(detectLoop(sLL2));

        System.out.println(detectLoop2(sLL));
        System.out.println(detectLoop2(sLL2));
    }

    /**
     * Floyd's cycle detection algorithm
     */
    public static <T> boolean detectLoop2(SinglyLinkedList<T> list) {
        System.out.println(list.size);

        Node<T> slow = list.head;
        Node<T> fast = list.head;
        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if (slow == fast) return true;
        }

        return false;
    }

    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        Set<T> numberSet = new HashSet<>();

        Node<T> current = list.head;
        while (current != null) {
            if (!numberSet.add(current.data)) return true;
            current = current.nextNode;
        }

        return false;
    }
}
