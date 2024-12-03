package com.solvd.airportmanager.customgeneric;

import java.util.*;

public class CustomLinkedList<E> implements List<E> {

    // Linked List Node
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head; // the first element of list
    private Node<E> tail; // the last element of list
    private int size;    // count of elements of list

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //get the list size
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (E e : this) {
            if (Objects.equals(e, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " , size " + size);
        }
    }

    //Adding an element to the end of a list
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e); // create a new Node
        if (tail == null) {               // if the list is empty
            head = tail = newNode;
        } else {                        // add in the tail
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index); //Check that the index is correct
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    //Delete element by index
    @Override
    public E remove(int index) {
        checkIndex(index); //Check that the index is correct
        Node<E> prev = null;
        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        if (prev == null) { //remove head
            head = head.next;
            if (head == null) { // if the list is empty
                tail = null;
            }
        } else {
            prev.next = current.next;
            if (tail == current) { //remove tail
                tail = prev;
            }
        }
        size--;
        return current.data;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
