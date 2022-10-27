package com.example.util;


// collection

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
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

    private Node head;
    private Node last;

    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = newNode;
            return;
        }
        last.setNext(newNode);
        last = newNode;
    }

    public void add(int idx, E e) {
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return (temp != null) ? true : false;
            }

            @Override
            public E next() {
                E data = temp.getData();
                temp = temp.getNext();
                return data;
            }
        };
    }


}
