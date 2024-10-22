package com.example.LinkedList.review.singly;

import java.util.Iterator;

public class DefaultSinglyLinkedList<T> implements SinglyLinkedList<T> {
  private int size = 0;
  private Node<T> head, tail;

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
  public boolean contains(T element) {
    return indexOf(element) != -1;
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
  public T remove(Node<T> node) {
    if (node.getNext() == null)
      removeLast();
    if (node == head)
      removeFirst();
    Node<T> currentNode = head;
    T data = node.getData();
    while (currentNode != null) {
      if (currentNode.getNext().equals(node)) {
        currentNode.setNext(currentNode.getNext().getNext());
        node.setNext(null);
        node = null;
        size--;
        break;
      }
      currentNode = currentNode.getNext();
    }
    return data;
  }

  @Override
  public T remove(T element) {
    if (isEmpty())
      throw new RuntimeException("empty linked list!");
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.getData().equals(element))
        return remove(currentNode);
      currentNode = currentNode.getNext();
    }
    throw new NullPointerException("element not found");
  }

  @Override
  public T removeAt(int index) {
    if (isEmpty())
      throw new RuntimeException("empty linked list");
    if (index == 0)
      return removeFirst();
    if (index == size - 1)
      return removeLast();

    int i = 0;
    Node<T> currentNode = head;
    while (i != index - 1) {
      currentNode.getNext();
      i++;
    }
    return remove(currentNode);
  }

  @Override
  public T removeFirst() {
    if (isEmpty())
      throw new RuntimeException("empty linked list");
    T data = head.getData();
    head = head.getNext();
    return data;
  }

  @Override
  public T removeLast() {
    if (isEmpty())
      throw new RuntimeException("empty linked list");
    Node<T> currentNode = head;
    T data = tail.getData();

    while (currentNode != null) {
      if (currentNode.getNext().equals(tail)) {
        currentNode.setNext(null);
        tail = currentNode;
        break;
      }
      currentNode = currentNode.getNext();
    }
    return data;
  }

  @Override
  public int indexOf(T element) {
    int index = 0;
    Node<T> currenNode = head;
    while (currenNode != null) {
      if (currenNode.getData().equals(element)) {
        return index;
      }
      currenNode = currenNode.getNext();
      index++;
    }
    return -1;
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
