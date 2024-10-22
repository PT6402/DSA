package com.example.LinkedList.review.singly;

public interface SinglyLinkedList<T> extends Iterable<T> {
  int size();

  boolean isEmpty();

  boolean contains(T element);

  void add(T element);

  void addFirst(T element);

  void addLast(T element);

  T remove(Node<T> node);

  T remove(T element);

  T removeAt(int index);

  T removeFirst();

  T removeLast();

  int indexOf(T element);
}
