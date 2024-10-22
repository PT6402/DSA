package com.example.LinkedList.singly_linked_list;

public interface SinglyLinkedList<T> extends Iterable<T> {

  boolean isEmpty();

  void clear();

  boolean contains(T element);

  int size();

  void add(T element);

  void addFirst(T element);

  void addLast(T element);

  T remove(T element);

  T remove(Node<T> node);

  T removeFirst();

  T removeLast();

  T removeAt(int index);

  void insert(int index, T element);

  int indexOf(T element);

  T peekFirst();

  T peekLast();

}
