package stack.concept;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
    // We need thing can save data and link another thing.
    // It's a node. So I'm going to be make node as inner class because it just used in Stack class
    private static class Node {
        private int data; // it's for saving data
        private Node next; // it's for pointing next node.

        private Node(int data) {
            this.data = data; // The node needs data initially when was created.
            this.next = null; // Then next field for pointing previous node. so it is going to set when input the new node.
        }
    }

    // The stack is First In Last Out data structure.
    // So, it needs to know where is top.
    // Then, we can add and remove from the top.
    private Node top = null; // remove node from the head

    // We need check that stack is empty, before remove the node.
    public boolean isEmpty() {
        return top == null; // The top is null means empty because don't have node at removing point.
    }

    // We need to get data of the first node. so I'm gonna a make method return the data of the first node.
    public int peek() {
        if (isEmpty()){ // it can't access data when head is null, so let's throw t he exception.
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Now, let's make method push a node to the top point.
    public void push(int data) {
        Node node = new Node(data); // we need to create new node.
        node.next = top; // this new node point to an old top. because this new node gonna a become the top.
        top = node; // and then the top point to new node.
    }
    // Okay, so that's all push has to do.

    // Also, let's make method remove the node. And it's going to return a data of first node.
    public int pop() {
        int data = peek(); // we can get the data of top node using peek method.
        top = top.next; // top need update to point down node. because top node is going to be removed.
        return data;
    }
    // Okay, so that's all pop has to do.
}
