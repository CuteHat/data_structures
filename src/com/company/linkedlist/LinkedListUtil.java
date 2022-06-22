package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

public class LinkedListUtil {

    public static SinglyLinkedList<Integer> getSll(String linkedListString) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        String delimiter = "->";

        for (String num : linkedListString.split(delimiter)) {
            sll.insertTail(Integer.valueOf(num));
        }
        return sll;
    }

}
