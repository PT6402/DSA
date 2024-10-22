package com.example.LinkedList.review.doubly;

public interface DoublyLinkedList<T> extends Iterable<T> {
  int size();

  boolean isEmpty();

  void add(T element);

  void addFirst(T element);

  void addLast(T element);

  T remove(T element);

  T remove(Node<T> node);

  T removeAt(int index);

  T removeFist();

  T removeLast();

  int indexOf(T element);

  T peekFirst();

  T peekLast();

  boolean contains(T element);

}
