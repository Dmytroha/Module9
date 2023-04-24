package task3;

public class MyQueue<T>{

    private Node<T> head; // first element
    private Node<T> tail; // last element
    private int size; // size of queue

    /**
     * Constructor of MyQueue
     */
    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add an element to the end of the queue.
     *
     * @param value the element to be added to the queue
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value); // create node
        if (tail != null) { // queue is not empty 
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    /**
     * Remove all elements from the queue.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Get the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Get the first element in the queue without removing it.
     *
     * @return the first element in the queue, or null if the queue is empty
     */
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    /**
     * Get and remove the first element in the queue.
     *
     * @return the first element in the queue, or null if the queue is empty
     */
    public T poll() {
        if (head == null) {
            return null;
        }
        T item = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }


}
