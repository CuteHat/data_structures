package com.company.linkedlist;

import com.company.linkedlist.doublylinkedlistwithtail.DoublyLinkedList;
import com.company.linkedlist.doublylinkedlistwithtail.Node;

/**
 * This challenge is easier to perform on a doubly linked-list with a tail pointer than on a singly linked-list.
 * Let’s first see what a palindrome is. A palindrome is any string or sequence that reads the same from both ends.
 * Your function will return a boolean variable; true when linked-list is a palindrome, false when it is not.
 */
public class isPalindrome {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = LinkedListUtil.getDll("1<->2<->3<->2<->1");
        dll.printList();
        System.out.println(isPalindrome2(dll));
    }

    /**
     * recursive solution
     */
    public static <T> boolean isPalindrome2(DoublyLinkedList<T> list) {
        Node<T> head = list.getHeadNode();
        Node<T> tail = list.getTailNode();

        if (head == null && tail == null)
            return true;
        else if (head.data != tail.data)
            return false;

        list.deleteAtHead();
        list.deleteAtTail();
        return isPalindrome2(list);
    }


    public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        Node<T> head = list.getHeadNode();
        Node<T> tail = list.getTailNode();

        while (head != null && tail != null) {
            if (head.data != tail.data)
                return false;
            list.deleteAtHead();
            list.deleteAtTail();
            head = list.getHeadNode();
            tail = list.getTailNode();
        }

        return true;
    }

}
