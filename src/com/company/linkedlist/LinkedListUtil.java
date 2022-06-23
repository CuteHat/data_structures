package com.company.linkedlist;

import com.company.linkedlist.doublylinkedlistwithtail.DoublyLinkedList;
import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

public class LinkedListUtil {

    public static SinglyLinkedList<Integer> getSll(String linkedListString) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        String delimiter = "->";

        for (String num : linkedListString.split(delimiter)) {
            sll.insertAtEnd(Integer.valueOf(num));
        }
        return sll;
    }

    public static DoublyLinkedList<Integer> getDll(String linkedListString) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        String delimiter = "<->";

        for (String num : linkedListString.split(delimiter)) {
            dll.insertAtEnd(Integer.valueOf(num));
        }
        return dll;
    }

}
