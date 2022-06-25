package com.company.linkedlist;

import com.company.linkedlist.frommaterial.LinkedList;
import com.company.linkedlist.frommaterial.LinkedListNode;

import java.util.List;

/**
 * Given the head of a singly linked list and an integer n, rotate the linked list by n and return the rotated linked list.
 * Note: The value of n can be larger than the length of the linked list.
 * Note: For positive integers, we’ll do a positive rotation and for negative integers, we’ll do a left rotation.
 */
public class RotateLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(List.of(1, 2, 3, 4, 5));
        LinkedListNode head = linkedList.head;
//        rotateList(head, 0);
//        linkedList.displayLinkedList();
        LinkedListNode newHead = rotateList(head, -2);
        linkedList.head = newHead;
        linkedList.displayLinkedList();
    }

    public static LinkedListNode rotateList(LinkedListNode head, int n) {
        int length = getLength(head);
        if (n == 0 || length == 0) return head;
        if (n < 0) n = length - (-1 * n);
        if (n > length) n = n % length;

        int stepsToNewHead = length - n;

        LinkedListNode newTail = null;
        LinkedListNode newHead = null;
        LinkedListNode currentTail = head;
        while (currentTail.next != null) {
            if (stepsToNewHead - 1 == 0)
                newTail = currentTail;
            else if (stepsToNewHead == 0)
                newHead = currentTail;
            currentTail = currentTail.next;
            stepsToNewHead--;
        }

        if (newHead == null) newHead = currentTail;

        currentTail.next = head;
        newTail.next = null;

        return newHead;
    }

    public static int getLength(LinkedListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
