package com.company.linkedlist.doublylinkedlistwithtail;

public class DoublyLinkedList<T> {
    public Node<T> headNode;
    public Node<T> tailNode;
    public int size;

    public DoublyLinkedList() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    //returns true if list is empty
    public boolean isEmpty() {
        if (headNode == null && tailNode == null) //checking tailNode to make sure
            return true;
        return false;
    }

    //getter for headNode
    public Node<T> getHeadNode() {
        return headNode;
    }

    //getter for tailNode
    public Node<T> getTailNode() {
        return tailNode;
    }

    //getter for size
    public int getSize() {
        return size;
    }

    public void insertAtHead(T data) {
        Node<T> newHead = new Node<>(null, data, headNode);
        if (!isEmpty()) {
            headNode.prevNode = newHead;
        } else {
            tailNode = newHead;
        }

        headNode = newHead;
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node<T> newTail = new Node<>(this.tailNode, data, null);
        tailNode.nextNode = newTail;
        tailNode = newTail;
        size++;
    }

    public void deleteAtHead() {
        if (isEmpty()) return;

        headNode = this.headNode.nextNode;
        if (headNode != null) {
            headNode.prevNode = null;
        } else {
            tailNode = null;
        }
        size--;
    }

    public void deleteAtTail() {
        if (isEmpty()) return;

        tailNode = tailNode.prevNode;
        if (tailNode != null) {
            tailNode.nextNode = null;
        } else {
            headNode = null;
        }
        size--;
    }

    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node<T> currentNode = this.headNode;

        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null)
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }

    //print list function
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node<T> temp = headNode;
        System.out.print("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

}