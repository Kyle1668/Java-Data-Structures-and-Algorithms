package com.company;

class Stack {

    class Node {
        int userID;
        String userName;
        Node previousNode;

        Node(int id, String name, Node prev) {
            userID = id;
            userName = name;
            previousNode = prev;
        }

    }

    private Node top;
    private int numItems;

    // Init

    Stack() {
        top = null;
        numItems = 0;
    }

    Stack(int id, String name) {
        top = new Node(id, name, null);
    }

    // Getters

    Node peek() {
        return top;
    }

    int size() {
        return numItems;
    }

    boolean isEmpty() {
        return numItems == 0;
    }

    void print() {
        print(top);
    }

    private void print(Node current) {
        System.out.print("ID: " + current.userName + "\n");
        System.out.print("Name: " + current.userName + "\n");
        if (current.previousNode != null) {
            print(current.previousNode);
        }
    }

    // Operations

    void push(int id, String name) {
        Node newNode = new Node(id, name, null);
        numItems++;
        if (numItems == 0) {
            top = newNode;
        }
        else {
            newNode.previousNode = top;
            top = newNode;
        }
    }

    void pop() {
        if (numItems != 0) {
            top = numItems == 1 ? null : top.previousNode;
        }
    }

    Node search(int target) {
        return numItems == 0 ? null : search(target, top);
    }

    private Node search(int target, Node current) {
        if (current.userID == target) {
            return current;
        }
        else if (current.previousNode != null) {
            return search(target, current.previousNode);
        }
        else {
            return null;
        }
    }

}

public class Main {

    public static void main(String[] args) {

        Stack users = new Stack();

        users.push(848120769, "Kyle O'Brien");
        users.push(707292668, "Lydia O'Brien");
        users.push(707431872, "Donna O'Brien");
        users.push(707292014, "Peter O'Brien");
        users.push(707282463, "Emmy O'Brien");

        users.print();

        System.out.print("\n" + "Search for 12345678: " + users.search(12345678).userName + "\n");
        System.out.print("\n" + "Search for 848120769: " + users.search(848120769).userName + "\n");

    }
}
