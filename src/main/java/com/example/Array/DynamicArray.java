package com.example.Array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable {
  private T[] arr;
  private int capacity = 0;
  private int size = 0;

  public DynamicArray() {
    this(10);
  }

  public DynamicArray(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("capacity canot be negative: " + capacity);

    this.capacity = capacity;
    arr = (T[]) new Object[capacity];
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public T get(int index) {
    return arr[index];
  }

  public void set(int index, T element) {
    arr[index] = element;
  }

  public void clear() {
    for (int i = 0; i < size; i++) {
      arr[i] = null;
    }
    this.size = 0;
  }

  public void add(T element) {
    if (size >= capacity - 1) {
      // if (capacity == 0) {
      // capacity = 1;
      // }
      // else {
      capacity++;
      // }

      T[] newArr = (T[]) new Object[capacity];
      for (int i = 0; i < arr.length; i++) {
        newArr[i] = arr[i];
      }

      arr = newArr;
    }
    arr[size++] = element;
  }

  public void removeAt(int index) {
    if (index >= size || index < 0)
      throw new IndexOutOfBoundsException();
    System.out.println("size before: " + size);
    System.out.println("length before: " + arr.length);
    T[] newArray = (T[]) new Object[size - 1];
    for (int oldIndex = 0, newIndex = 0; oldIndex < size; oldIndex++, newIndex++) {
      if (oldIndex == index)
        newIndex--;
      else
        newArray[newIndex] = arr[oldIndex];

    }

    arr = newArray;
    capacity = --size;
    System.out.println("size after: " + size);
    System.out.println("length after: " + arr.length);
  }

  public void remove(Object object) {
    int index = indexOf(object);
    removeAt(index);
  }

  public int indexOf(Object object) {
    for (int i = 0; i < size; i++) {
      if (object == null) {
        if (arr[i] == null)
          return i;
      } else {
        if (object.equals(arr[i]))
          return i;
      }

    }
    return -1;
  }

  public boolean contains(Object object) {
    return indexOf(object) != -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @Override
      public T next() {
        return arr[index++];
      }

    };
  }

  @Override
  public String toString() {
    if (size == 0)
      return "[]";
    else {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < size - 1; i++) {
        sb.append(arr[i]).append(",");

      }
      sb.append(arr[size - 1]).append("]");
      return sb.toString();
    }
  }
}
