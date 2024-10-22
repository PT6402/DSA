package com.example.Array;

import java.util.Iterator;

/**
 * ReviewDynamicArray
 */
public class ReviewDynamicArray<T> implements Iterable<T> {
  private T[] arr;
  private int size = 0;
  private int capacity = 0;

  public ReviewDynamicArray() {
    this(1);
  }

  private ReviewDynamicArray(int capacity) {
    if (capacity <= 0)
      throw new IllegalArgumentException("capacity cannot negative or zero: " + capacity);
    this.capacity = capacity;
    arr = (T[]) new Object[capacity];
  }

  public T get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    return arr[index];
  }

  public void set(int index, T element) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    arr[index] = element;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void add(T element) {
    if (size >= capacity - 1) {
      capacity *= 2;

      // resize capacity
      T[] newArray = (T[]) new Object[capacity];
      for (int i = 0; i < size; i++) {
        newArray[i] = arr[i];
      }
      arr = newArray;
    }

    arr[size++] = element;
  }

  public void removeAt(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    T[] newArray = (T[]) new Object[capacity];
    for (int oldIndex = 0, newIndex = 0; oldIndex < size; oldIndex++, newIndex++) {
      if (index == oldIndex)
        oldIndex++;
      newArray[newIndex] = arr[oldIndex];
    }
    arr = newArray;
    size--;
  }

  public void remove(T element) {
    int index = indexOf(element);
    removeAt(index);
  }

  public int indexOf(T element) {
    for (int i = 0; i < size; i++) {
      if (element == null) {
        if (arr[i] == null)
          return i;
      } else {
        if (arr[i].equals(element))
          return i;
      }
    }
    return -1;
  }

  public void insert(int index, T element) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException();
    if (index == size) {
      arr[size] = element;
    } else {
      T[] newArray = (T[]) new Object[capacity];
      for (int oldIndex = 0, newIndex = 0; oldIndex < size; oldIndex++, newIndex++) {
        if (oldIndex == index) {
          newArray[newIndex] = element;
          newArray[++newIndex] = arr[oldIndex];
          continue;
        }
        newArray[newIndex] = arr[oldIndex];
      }
      arr = newArray;
    }
    size++;
  }

  public void clear() {
    for (int i = 0; i < size; i++) {
      arr[i] = null;
    }
  }

  public boolean contains(T element) {
    return indexOf(element) != -1;
  }

  @Override
  public String toString() {
    if (size == 0)
      return "[]";
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < size - 1; i++) {
      sb.append(arr[i]).append(",");
    }
    sb.append(arr[size - 1]).append("]");
    return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        return arr[index++];
      }

    };
  }

}