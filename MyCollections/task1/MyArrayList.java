package task1;

public class MyArrayList<E>{
    private final int CLUSTER_SIZE=10;

    private Object[] storage;  // array for storing data
    private int sizeOfCollection; // size of collection (how many elements in storage)
    //    constructor
    public MyArrayList() {
        storage = new Object[CLUSTER_SIZE]; // create initial array of Objects
        sizeOfCollection = 0;
    }

    // append element
    public void add(E value) {
        if (sizeOfCollection == storage.length) { // if not enough of room in storage
            // enlarge storage
            Object[] newStorage = new Object[storage.length + CLUSTER_SIZE];
            System.arraycopy(storage, 0, newStorage, 0, storage.length);
            storage = newStorage;
        }
        storage[sizeOfCollection] = value;
        sizeOfCollection++;
    }

    // remove element by index
    public void remove(int index) {
        if (index < 0 || index >= sizeOfCollection) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + sizeOfCollection);
        }
        // shift elements for 1
        System.arraycopy(storage, index + 1, storage, index, sizeOfCollection - (index+1));
        sizeOfCollection--;
        storage[sizeOfCollection] = null;  // erase last element
    }

    // cleaning collection
    public void clear() {
        for (int i = 0; i < sizeOfCollection; i++) {
            storage[i] = null;
        }
        sizeOfCollection = 0;
    }

    // return size of collection
    public int size() {
        return sizeOfCollection;
    }

    // return element
    public E get(int index) {
        if (index < 0 || index >= sizeOfCollection) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + sizeOfCollection);
        }
        return (E) storage[index]; // correct type cast not guarantied in this case "but I try"
    }
}
