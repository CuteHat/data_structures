package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.Node;
import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

/**
 * In this problem, you have to implement Object nthElementFromEnd(SinglyLinkedList<T> list, int n) method,
 * which will take a linked list as an input and returns the nth element of the list from the end.
 * To solve this, you will have to come up with a formula by comparing multiple outputs and inputs and identifying
 * a common pattern. An illustration is also provided for your understanding.
 */
public class NthNodeForTheEnd {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = LinkedListUtil.getSll("22->18->60->78->47->39->99");
        System.out.println(nthElementFromEnd(sll, 7));
    }

    /**
     * this solution depends on having value of list size
     */
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int index = list.size - n + 1;
        if (index <= 0) return null;
        int i = 1;

        Node<T> target = list.headNode;
        while (i != index) {
            target = target.nextNode;
            i++;
        }

        return target.data;
    }

}
