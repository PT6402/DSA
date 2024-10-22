package com.example.LinkedList.review.doubly;

import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements DoublyLinkedList<T> {
  private int size = 0;
  private Node<T> head = null, tail = null;

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node<T> currentNode = head;

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
  public int size() {
    return this.size;
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
    if (isEmpty())
      head = tail = new Node<>(element, null, null);
    else {
      head.setPrev(new Node<>(element, null, head));
      head = head.getPrev();
    }
    size++;
  }

  @Override
  public void addLast(T element) {
    if (isEmpty())
      head = tail = new Node<>(element, null, null);
    else {
      tail.setNext(new Node<>(element, tail, null));
      tail = tail.getNext();
    }
    size++;
  }

  @Override
  public T remove(T element) {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getData().equals(element))
        return remove(currentNode);
      currentNode = currentNode.getNext();
    }

    throw new RuntimeException("not found !");
  }

  @Override
  public T remove(Node<T> node) {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");

    if (node.getPrev() == null)
      return removeFist();
    if (node.getNext() == null)
      return removeLast();
    Node<T> currentNode = head;

    while (currentNode != null) {
      if (currentNode.equals(node)) {
        break;
      }
      currentNode = currentNode.getNext();
    }
    T data = node.getData();
    currentNode.getNext().setPrev(currentNode.getPrev());
    currentNode.getPrev().setNext(currentNode.getNext());
    node.setNext(null);
    node.setPrev(null);
    node = null;
    size--;
    return data;
  }

  @Override
  public T removeAt(int index) {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");
    if (index == 0)
      return removeFist();
    if (index == size - 1)
      return removeLast();
    Node<T> currentNode = head;
    int i;
    if (index < size / 2) {
      i = 0;
      while (i != index) {
        currentNode = currentNode.getNext();
        i++;
      }
    } else {
      i = size - 1;
      while (i != index) {
        currentNode = currentNode.getPrev();
        i--;
      }
    }
    return remove(currentNode);
  }

  @Override
  public T removeFist() {
    if (isEmpty())
      throw new RuntimeException("emtpy linked list!");
    T data = head.getData();
    head = head.getNext();
    size--;
    if (isEmpty())
      tail = null;
    else
      head.setPrev(null);
    return data;
  }

  @Override
  public T removeLast() {
    if (isEmpty())
      throw new RuntimeException("emtpy linked list!");
    T data = tail.getData();
    tail = tail.getPrev();
    size--;
    if (isEmpty())
      head = null;
    else
      tail.setNext(null);
    return data;
  }

  @Override
  public int indexOf(T element) {
    if (isEmpty())
      throw new RuntimeException("emtpy linked list!");
    Node<T> currentNode = head;
    int index = 0;
    while (currentNode != null) {
      if (currentNode.getData().equals(element)) {
        return index;
      }
      currentNode = currentNode.getNext();
      index++;
    }
    return -1;
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
  public boolean contains(T element) {
    return indexOf(element) != -1;
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
      } else {
        sb.append("]");
      }
      currentNode = currentNode.getNext();
    }
    return sb.toString();
  }
}
