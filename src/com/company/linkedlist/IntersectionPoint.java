package com.company.linkedlist;


import com.company.linkedlist.frommaterial.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head nodes of two linked lists, return the node at which the two lists intersect.
 * We will return null if we do not find any intersection between the two linked lists.
 * The linked lists have to physically intersect. This means that their addresses need to be the same.
 * If two nodes have the same data but their addresses are not the same,
 * the lists won’t intersect and the function should return null.
 */
public class IntersectionPoint {
    public static void main(String[] args) {

    }

    // solution without set
    public static LinkedListNode intersect2(LinkedListNode head1, LinkedListNode head2) {
        int list1Length = getLength(head1);
        int list2Length = getLength(head2);

        LinkedListNode longHead = null;
        LinkedListNode shortHead = null;

        if (list1Length > list2Length) {
            longHead = head1;
            shortHead = head2;
        } else {
            longHead = head2;
            shortHead = head1;
        }

        int lengthDifference = list1Length - list2Length;
        lengthDifference = lengthDifference < 0 ? lengthDifference * -1 : lengthDifference;

        while (lengthDifference != 0) {
            longHead = longHead.next;
            lengthDifference--;
        }

        while (longHead != null) {
            if (longHead.equals(shortHead))
                return longHead;
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return null;
    }

    public static int getLength(LinkedListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // solution using set
    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        Set<LinkedListNode> list1Nodes = new HashSet<>();
        while (head1 != null) {
            list1Nodes.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (list1Nodes.contains(head2))
                return head2;
            head2 = head2.next;
        }
        return null;
    }

}
