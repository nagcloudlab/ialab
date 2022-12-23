package org.example.util;

import java.util.Iterator;
import java.util.List;

/**

 author: Nag

 */

public class LinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void add(int index,E data){
    }
    public E get(int index){
        return null;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current!= null;
            }
            @Override
            public E next() {
                E data=null;
                if (current != null) {
                    data = current.data;
                    current = current.next;
                }
                return data;
            }
        };
    }

    private class Node{
        private E data;
        private Node next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
