package task1;

public class MyArrayList {
    private Object[] data;  // array for storing data
    private int size;       // size of collection

    public MyArrayList() {
        data = new Object[10]; // create initial array of Objects - 10 элементов
        size = 0;
    }

    // append element
    public void add(Object value) {
        if (size == data.length) {
            // если массив заполнен, увеличиваем его размер в 2 раза
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = value;
    }

    // remove element by index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // shift elemets for 1
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;  // освобождаем последний элемент массива
    }

    // cleaning collection
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // return size of collection
    public int size() {
        return size;
    }

    // return element
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }
}
