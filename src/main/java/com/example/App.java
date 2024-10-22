package com.example;

import com.example.LinkedList.review.doubly.DefaultDoublyLinkedList;

public class App {
    public static void main(String[] args) {
        DefaultDoublyLinkedList<String> linkedList = new DefaultDoublyLinkedList<>();
        try {
            linkedList.add("p");
            linkedList.add("h");
            linkedList.add("a");
            linkedList.add("t");
            System.out.println(linkedList);
            // linkedList.remove("r");
            System.out.println(linkedList.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // System.out.println(linkedList.contains("a"));
        // linkedList.clear();
        System.out.println(linkedList);
    }
}
