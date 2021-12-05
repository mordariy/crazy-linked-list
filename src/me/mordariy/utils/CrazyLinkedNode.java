package me.mordariy.utils;

public class CrazyLinkedNode<E> {

    private E element;
    private CrazyLinkedNode<E> next;
    private CrazyLinkedNode<E> previous;

    public CrazyLinkedNode(CrazyLinkedNode<E> previous, E element, CrazyLinkedNode<E> next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public CrazyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(CrazyLinkedNode<E> next) {
        this.next = next;
    }

    public CrazyLinkedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(CrazyLinkedNode<E> previous) {
        this.previous = previous;
    }
}
