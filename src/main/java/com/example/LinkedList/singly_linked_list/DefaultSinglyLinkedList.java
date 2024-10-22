package com.example.LinkedList.singly_linked_list;

import java.util.Iterator;

public class DefaultSinglyLinkedList<T> implements SinglyLinkedList<T> {

  private int size = 0;
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
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void clear() {
    Node<T> currentNode = head;
    while (currentNode != null) {
      currentNode.setData(null);
      currentNode = currentNode.getNext();
    }
    this.size = 0;
  }

  @Override
  public boolean contains(T element) {
    return indexOf(element) != -1;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public void add(T element) {
    addLast(element);
  }

  @Override
  public void addFirst(T element) {
    if (isEmpty()) {
      head = tail = new Node<>(element, null);
    } else {
      head = new Node<>(element, head);
    }
    size++;
  }

  @Override
  public void addLast(T element) {
    if (isEmpty()) {
      head = tail = new Node<>(element, null);
    } else {
      tail.setNext(new Node<>(element, null));
      tail = tail.getNext();
    }
    size++;
  }

  @Override
  public T remove(T element) {
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getData().equals(element))
        return remove(currentNode);
      currentNode = currentNode.getNext();
    }
    return null;
  }

  @Override
  public T removeFirst() {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");
    T data = head.getData();
    head = head.getNext();
    size--;
    return data;

  }

  @Override
  public T removeLast() {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");
    T data = tail.getData();
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getNext().equals(tail)) {
        tail = currentNode.getNext();
        tail.setNext(null);
        currentNode.setNext(null);
        break;
      }
      currentNode = currentNode.getNext();
    }
    size--;
    return data;
  }

  @Override
  public T removeAt(int index) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException();
    int i = 0;
    Node<T> currentNode = head;
    if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    }

    else {
      while (i <= index - 1) {
        currentNode = currentNode.getNext();
        i++;
      }
      remove(currentNode);
    }
    T data = currentNode.getData();
    return data;
  }

  @Override
  public void insert(int index, T element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public int indexOf(T element) {
    Node<T> currentNode = head;
    int index = 0;
    while (currentNode != null) {
      if (currentNode.getData().equals(element))
        return index;
      currentNode = currentNode.getNext();
      index++;
    }

    return -1;
  }

  @Override
  public T peekFirst() {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");
    return head.getData();
  }

  @Override
  public T peekLast() {
    if (isEmpty())
      throw new RuntimeException("empty linked list !");
    return tail.getData();
  }

  @Override
  public T remove(Node<T> node) {
    if (node.getNext() == null) {
      return removeLast();
    }
    if (node.equals(head)) {
      return removeFirst();
    }
    T data = node.getData();

    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getNext().equals(node)) {
        currentNode.setNext(node.getNext());
        size--;
        node.setData(null);
        node.setNext(null);
        node = null;
        return data;
      }
      currentNode = currentNode.getNext();
    }
    return null;
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
