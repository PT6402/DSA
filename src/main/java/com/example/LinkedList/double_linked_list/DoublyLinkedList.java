package com.example.LinkedList.double_linked_list;

public interface DoublyLinkedList<T> extends Iterable<T> {
  void clear();

  int size();

  boolean isEmpty();

  void add(T element);

  void addFirst(T element);

  void addLast(T element);

  T peekFirst();

  T peekLast();

  boolean removeFisrt();

  boolean removeLast();

  boolean remove(Node<T> node);

  boolean remove(Object object);

  boolean removeAt(int index);

  int indexOf(Object object);

  boolean contains(Object object);

}
