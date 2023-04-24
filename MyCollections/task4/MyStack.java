package task4;

import java.util.NoSuchElementException;

public class MyStack <T>{

        private Object[] data;  // storage for stack
        private int size; //size of saved data in stack

    /**
     *  constructor MyStack
     */

    public MyStack() {
            data = new Object[10];
            size = 0;
        }

    /**
     * push(save) value to stack
     * @param value
     */
        public void push(T value) {
            if (size == data.length) { // if stack full
                Object[] newData = new Object[data.length * 2]; // add space
                System.arraycopy(data, 0, newData, 0, data.length);  // copy stack to new space
                data = newData;
            }
            data[size++] = value; // save value and increment size
        }

    /**
     * remove element by index and return it
     * @param index
     * @return
     */
        public T remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            T removed = (T) data[index];
            System.arraycopy(data, index + 1, data, index, size - (index + 1));
            data[--size] = null;
            return removed;
        }

    /**
     *
     * clear stack
     */
        public void clear() {
            for (int i = 0; i < size; i++) {
                data[i] = null;
            }
            size = 0;
        }

    /**
     * return size
     * @return
     */
        public int size() {
            return size;
        }

    /**
     * return first element from stack without removing
     * @return
     */
        public T peek() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            return (T) data[size - 1];
        }

    /**
     * return first element from stack and remove it
     *
     * @return
     */
        public T pop() {
            T popped = peek();
            data[--size] = null;
            return popped;
        }
}



