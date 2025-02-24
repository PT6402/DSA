package com.example.LinkedList.double_linked_list;

import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements DoublyLinkedList<T> {
  private int size;
  private Node<T> head = null;
  private Node<T> tail = null;

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> currentNode = head;

      @Override
      public boolean hasNext() {
        return currentNode != null;
      }

      @Override
      public T next() {
        return currentNode.getNext().getData();
      }

    };
  }

  @Override
  public void clear() {
    Node<T> currentNode = head;
    while (currentNode != null) {
      Node<T> nextNode = currentNode.getNext();
      currentNode.setNext(null);
      currentNode.setPrev(null);
      currentNode.setData(null);
      currentNode = nextNode;
      head = tail = null;
    }
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void add(T element) {
    addLast(element);
  }

  @Override
  public void addFirst(T element) {
    if (isEmpty()) {
      head = tail = new Node<>(element, null, null);
    } else {
      head.setPrev(new Node<>(element, null, head));
      head = head.getPrev();
    }
    size++;
  }

  @Override
  public void addLast(T element) {
    if (isEmpty()) {
      head = tail = new Node<>(element, null, null);
    } else {
      tail.setNext(new Node<>(element, tail, null));
      tail = tail.getNext();
    }
    size++;
  }

  @Override
  public T peekFirst() {
    if (isEmpty())
      throw new RuntimeException("empty linked list!");
    return head.getData();
  }

  @Override
  public T peekLast() {
    if (isEmpty())
      throw new RuntimeException("empty linked list!");
    return tail.getData();
  }

  @Override
  public boolean removeFisrt() {
    if (isEmpty())
      throw new RuntimeException("empty linked list!");
    head = head.getNext();
    size--;
    if (isEmpty())
      tail = null;
    else
      head.setPrev(null);
    return true;
  }

  @Override
  public boolean removeLast() {
    if (isEmpty())
      throw new RuntimeException("empty linked list!");

    tail = tail.getPrev();
    size--;
    if (isEmpty())
      head = null;
    else
      tail.setNext(null);
    return true;
  }

  @Override
  public boolean remove(Node<T> node) {
    if (node.getPrev() == null)
      return removeFisrt();
    if (node.getNext() == null)
      return removeLast();

    node.getNext().setPrev(node.getPrev());
    node.getPrev().setNext(node.getNext());

    size--;
    node.setData(null);
    node.setPrev(null);
    node.setNext(null);
    node = null;
    return true;
  }

  @Override
  public boolean remove(Object object) {
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getData().equals(object)) {
        return remove(currentNode);
      }
      currentNode = currentNode.getNext();
    }
    return false;
  }

  @Override
  public boolean removeAt(int index) {
    if (index < 0 || index > size)
      throw new IllegalArgumentException();

    Node<T> currentNode;
    int i;

    if (index < size / 2) {
      i = 0;
      currentNode = head;
      while (i != index) {
        currentNode = currentNode.getNext();
        i++;
      }
    } else {
      i = size - 1;
      currentNode = tail;
      while (i != index) {
        currentNode = currentNode.getPrev();
        i--;
      }

    }
    return remove(currentNode);
  }

  @Override
  public int indexOf(Object object) {
    int index = 0;
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getData().equals(object)) {
        return index;
      }
      currentNode = currentNode.getNext();
      index++;
    }
    return -1;
  }

  @Override
  public boolean contains(Object object) {
    return indexOf(object) != -1;
  }

  @Override
  public String toString() {
    if (isEmpty())
      return "[]";
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<T> currentNode = head;
    while (currentNode != null) {
      sb.append(currentNode.getData());
      if (currentNode.getNext() != null) {
        sb.append(",");
      }
      currentNode = currentNode.getNext();
    }
    sb.append("]");
    return sb.toString();
  }

}
