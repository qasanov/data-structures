package com.qasanov.ds.linkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;

    public E getHead(){
        if(head == null)
            throw new NoSuchElementException();
        return head.item;
    }

    public E getTail(){
        if(tail == null)
            throw new NoSuchElementException();
        return tail.item;
    }

    public void insert(E element){
        Node<E> newNode = new Node<>(element,null);
        if(head == null) {
           head = newNode;
           tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insert(E afterElement, E newElement){
        if(head == null)
            insert(newElement);
        Node<E> node = head;
        while(node.next != null){
            if(node.item.equals(afterElement)){
               Node<E> newNode = new Node<>(newElement,node.next);
               node.next = newNode;
               break;
            }
            node = node.next;
        }
    }

    public int size(){
        if(head == null)
            return 0;
        int counter = 1;
        Node<E> node = head;
        while(node.next != null){
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void remove() {
        Node<E> node = head, previous = head;
        while (node!=null && node.next!=null){
            previous = node;
            node = node.next;
        }
        tail = previous;

        if(head == tail){
           resetList();
        }else if(previous!=null)
            previous.next = null;
    }

    public void removeAll(){
       resetList();
    }

    private void resetList(){
        head = null;
        tail = null;
    }


}
