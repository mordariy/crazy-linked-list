package me.mordariy.utils;

import java.util.Objects;

public class CrazyLinkedList<E> {

    private int size;
    private CrazyLinkedNode<E> first;
    private CrazyLinkedNode<E> last;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        CrazyLinkedNode<E> newNode = new CrazyLinkedNode<>(null, element, first);
        if (last == null) {
            last = newNode;
        } else {
            first.setPrevious(newNode);
        }

        first = newNode;
        size++;
    }

    public void add(int index, E element) {
        if (!(index < 0 || index >= size)) {
            CrazyLinkedNode<E> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            CrazyLinkedNode<E> newNode = new CrazyLinkedNode<>(currentNode.getPrevious(), element, currentNode);
            size++;
        }
    }

    public void add(E element) {
        CrazyLinkedNode<E> newNode = new CrazyLinkedNode<>(last, element, null);
        if (first == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void set(int index, E element) {
        if (!(index < 0 || index >= size)) {
            CrazyLinkedNode<E> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setElement(element);
        }
    }

    public void remove(E element) {
        CrazyLinkedNode<E> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.getElement().equals(element)) {
               CrazyLinkedNode<E> previous = currentNode.getPrevious();
               CrazyLinkedNode<E> next = currentNode.getNext();
               previous.setNext(next);
               next.setPrevious(previous);
               size--;
               break;
            }
            currentNode = currentNode.getNext();
        }
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        CrazyLinkedNode<E> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getElement();
    }

    public int indexOf(E element) {
        CrazyLinkedNode<E> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.getElement().equals(element)) {
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    public boolean contains(E element) {
        CrazyLinkedNode<E> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.getElement().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("CrazyLinkedList{");


        if (size == 0) {
            sb.append("}");
            return sb.toString();
        }

        CrazyLinkedNode<E> currentNode = first;
        for (int i = 0; i < size-1; i++) {
            sb.append(currentNode.getElement());
            sb.append(",");
            currentNode = currentNode.getNext();
        }

        sb.append(currentNode.getElement());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrazyLinkedList<?> that = (CrazyLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(first, that.first) &&
                Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, first, last);
    }
}
