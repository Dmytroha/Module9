package task2;

public class MyLinkedList<E> {
    private Node <E> head; // start element
    private Node <E> tail; //last element
    private int size; // size of collection

    public MyLinkedList() { // constructor  <---------- MyLinkedList
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

   private  Node<E> getNodeByIndex(int index){
       if (index < size / 2) {
           Node<E> currentNode = head;
           for (int i = 0; i < index; i++) {
               currentNode = currentNode.nextNode;
           }
           return currentNode;
       } else {
           Node<E> currentNode = tail;
           for (int i = size - 1; i > index; i--) {
               currentNode = currentNode.previousNode;
           }
           return currentNode;
       }

    }


    //internal class Node implementation
    private class Node<E>{
         E value;  // the value we store in MyLinkedList  <---- value is here

        Node<E> previousNode; // link to prev and next node
        Node<E> nextNode; // link to nex node

        Node(E value, Node<E> previous, Node<E> next){  // constructor <---Node
            this.previousNode = previous;
            this.nextNode = next;
            this.value=value;

        }
        Node(E value){  // constructor <---Node
            this.previousNode = null;
            this.nextNode = null;
            this.value=value;

        }
    }



    public void add(E value){
        Node<E> newNode = new Node<>(value);
        if (this.head == null) { // if newNode fist element head and tail are the same
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.previousNode = this.tail; // tail become previous last
            this.tail.nextNode = newNode; // and gets nextNode as newNode
            this.tail = newNode; // newNode becomes the last
        }
        this.size++;  // we have new value added
    }

    public void remove(int index){

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(size==1) {
            clear();
            return;
        }

        Node<E> toRemoveNode = getNodeByIndex(index);
        if(toRemoveNode.previousNode!=null){ //if not head
            toRemoveNode.previousNode.nextNode=toRemoveNode.nextNode;

        } else{
            head = toRemoveNode.nextNode;
        }

        if (toRemoveNode.nextNode != null) { //if not tail
            toRemoveNode.nextNode.previousNode = toRemoveNode.previousNode;
        } else {
            tail = toRemoveNode.previousNode;
        }
        size--;

    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNodeByIndex(index).value;
    }


}
