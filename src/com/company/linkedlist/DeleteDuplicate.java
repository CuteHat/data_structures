package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.Node;
import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * In this problem, you have to implement public static <T> void removeDuplicates(SinglyLinkedList<T> list) method.
 * This method will take a Singly linked list as input and remove all the elements that appear more than once in the list.
 * An illustration is also provided for your understanding.
 */
public class DeleteDuplicate {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = LinkedListUtil.getSll("7->14->21->14->22");
        SinglyLinkedList<Integer> sll2 = LinkedListUtil.getSll("4->2321->4->55->1000");
        SinglyLinkedList<Integer> sll3 = LinkedListUtil.getSll("1000->55->4->2321->55->1000");
        removeDuplicates(sll3);
        sll3.printList();
    }

    /**
     * kind of a cheat way, cause this way list.size is out of sync.
     */
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        Set<T> uniqueData = new HashSet<>();

        Node<T> current = list.headNode;
        Node<T> prevNode = null;
        while (current != null) {

            if (!uniqueData.add(current.data)) {
                prevNode.nextNode = current.nextNode;
            } else {
                prevNode = current;
            }
            current = current.nextNode;
        }
    }
}
