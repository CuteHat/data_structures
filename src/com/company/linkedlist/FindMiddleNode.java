package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.Node;
import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

import java.util.ArrayList;

public class FindMiddleNode {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = LinkedListUtil.getSll("7->14->10->21");
        System.out.println(findMiddle3(sll));
    }

    /**
     * Smartest solution !
     */
    public static <T> Object findMiddle3(SinglyLinkedList<T> list) {
        Node<T> current = list.headNode; // goes twice as fast
        Node<T> mid = list.headNode;

        while (current != null && current.nextNode != null) {
            current = current.nextNode.nextNode;
            if (current != null) mid = mid.nextNode;
        }

        return mid.data;
    }

    /**
     * Indexize every parameter  and calculate middle index
     */
    public static <T> Object findMiddle2(SinglyLinkedList<T> list) {
        ArrayList<T> values = new ArrayList<>();
        Node<T> current = list.headNode;

        while (current != null) {
            values.add(current.data);
            current = current.nextNode;
        }

        // 3 -> 1
        // 4 -> 1
        int midIndex = (values.size() - 1) / 2;

        return values.get(midIndex);
    }


    /**
     * if we know size the task is pretty simple
     */
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        int midIndex = list.size / 2;
        if (list.size % 2 == 0) midIndex--;

        int indexCounter = 0;
        Node<T> current = list.headNode;
        while (current != null) {
            if (indexCounter == midIndex)
                return current.data;
            current = current.nextNode;
            indexCounter++;
        }

        return -1;
    }

}
