package com.company.linkedlist;

import com.company.linkedlist.singlylinkedlist.Node;
import com.company.linkedlist.singlylinkedlist.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * In this problem you have to implement two methods, i.e., SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2)
 * and SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2).
 * The first method will take two linked lists as input and return the union of the two lists.
 * A Union of two sets can be expressed as, “Union of two sets A and B is a set which contains all the elements present in A or B”.
 * Similarly, the second method will return the Intersection of two lists. The Intersection is commonly defined as,
 * “A set which contains all the elements present in A and B”.
 */
public class CheckUnionIntersection {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll1 = LinkedListUtil.getSll("15->22->8");
        SinglyLinkedList<Integer> sll2 = LinkedListUtil.getSll("7->14->22");
        SinglyLinkedList<Integer> sll3 = LinkedListUtil.getSll("4->3");
        SinglyLinkedList<Integer> sll4 = LinkedListUtil.getSll("4->5");
        SinglyLinkedList<Integer> sll5 = LinkedListUtil.getSll("5");
        SinglyLinkedList<Integer> sll6 = LinkedListUtil.getSll("10->15");

//        intersection(sll1, sll2).printList();
//        intersection2(sll1, sll2).printList();
        union(sll3, sll4).printList();
        union(sll5, sll6).printList();
    }

    /**
     * Cool af solution
     */
    public static <T> SinglyLinkedList<T> union3(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        // determine last node of list 1
        Node<T> last = list1.headNode;
        while (last.nextNode != null) {
            last = last.nextNode;
        }

        // attach first lists last node to second lists first node
        last.nextNode = list2.headNode;
        list1.removeDuplicatesWithHashing();
        return list1;
    }

    /**
     * Better solution then the one below
     */
    public static <T> SinglyLinkedList<T> union2(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        // add all elements from list 1
        Node<T> current = list1.headNode;
        while (current != null) {
            result.insertAtEnd(current.data);
            current = current.nextNode;
        }

        // add all the elements from list2
        current = list2.headNode;
        while (current != null) {
            result.insertAtEnd(current.data);
            current = current.nextNode;
        }

        // clear duplicates
        result.removeDuplicatesWithHashing();
        return result;
    }

    /**
     * brute force solution
     */
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        // add only unique elements from list 1
        Node<T> current = list1.headNode;
        while (current != null) {
            T currentData = current.data;
            Node<T> list2Current = list2.headNode;

            boolean hasDuplicateInList2 = false;
            while (list2Current != null) {
                if (currentData == list2Current.data)
                    hasDuplicateInList2 = true;

                list2Current = list2Current.nextNode;
            }
            if (!hasDuplicateInList2)
                result.insertAtEnd(currentData);

            current = current.nextNode;
        }

        // add all the elements from list2
        current = list2.headNode;
        while (current != null) {
            result.insertAtEnd(current.data);
            current = current.nextNode;
        }

        return result;
    }

    /**
     * brute force solution
     */
    public static <T> SinglyLinkedList<T> intersection2(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        Node<T> current = list1.headNode;
        while (current != null) {
            T currentData = current.data;
            Node<T> list2Current = list2.headNode;
            while (list2Current != null) {
                if (currentData == list2Current.data) {
                    result.insertAtEnd(currentData);
                }
                list2Current = list2Current.nextNode;
            }
            current = current.nextNode;
        }
        // in case list1 contains duplicate data
        // for exa list1 = 1->2->2->null, list2 = 2->3->null this will result 2 adding in result twice
        // so removing duplicates is crucial
        result.removeDuplicatesWithHashing();
        return result;
    }

    /**
     * with set
     */
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        Set<T> list1Set = new HashSet<>();

        Node<T> current = list1.headNode;
        while (current != null) {
            list1Set.add(current.data);
            current = current.nextNode;
        }

        current = list2.headNode;
        while (current != null) {
            if (!list1Set.add(current.data)) {
                result.insertAtEnd(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }
}
