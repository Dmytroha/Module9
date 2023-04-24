import task1.MyArrayList;
import task2.MyLinkedList;
import task3.MyQueue;
import task5.MyHashMap;

import java.sql.SQLOutput;

public class MyCollectionstest {
    public static void main(String[] args) {
        // test MyArrayList class
        System.out.println("<---------------Testing MyArrayList class----------->");
      MyArrayList<ObjectForTestCollections> someArrLst = new MyArrayList<>();
      // test add method
      someArrLst.add(new ObjectForTestCollections(5,6.35998f,"First element"));
      System.out.println(someArrLst.get(0).toString()+'\n'+"size:"+someArrLst.size());
      someArrLst.add(new ObjectForTestCollections(789,1.00005645f,"Second element"));
      System.out.println(someArrLst.get(1).toString()+'\n'+"size:"+someArrLst.size());

      // test remove method
      someArrLst.add(new ObjectForTestCollections(25,800f,"Third element:"));
      System.out.println(someArrLst.get(2).toString()+'\n'+"size:"+someArrLst.size());

      someArrLst.remove(1);
      System.out.println("After removing element with index 1"+someArrLst.get(1).toString()+" becomes Second "+'\n'+"size:"+someArrLst.size());

      //test clear method
      someArrLst.clear();
      System.out.println("Size after clean()"+someArrLst.size());
      //test exception
        try {
            ObjectForTestCollections tygydym = someArrLst.get(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds Exception");
        }

        System.out.println("<---------------Testing MyLinkedList class----------->");
        MyLinkedList<ObjectForTestCollections>  someLinkedList = new MyLinkedList<>();
        someLinkedList.add(new ObjectForTestCollections(11,6.35998f,"first MyLinkedList "));
        System.out.println(someLinkedList.get(0).toString()+'\n'+"size:"+someLinkedList.size());
        someLinkedList.add(new ObjectForTestCollections(22,1.00005645f,"The second one:"));
        System.out.println(someLinkedList.get(1).toString()+'\n'+"size:"+someLinkedList.size());
        // test remove method
        someLinkedList.add(new ObjectForTestCollections(33,800f,"Third element: of LinkedList"));
        System.out.println(someLinkedList.get(1).toString()+'\n'+"size:"+someLinkedList.size());

        someLinkedList.remove(1);
        System.out.println("After removing element with index 1 "+someLinkedList.get(1).toString()+"become Second"+'\n'+"size:"+someLinkedList.size());
        someLinkedList.clear();
        System.out.println("Size after clear(): "+someLinkedList.size());


        try {
            ObjectForTestCollections tygydym = someLinkedList.get(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds Exception");
        }
        // testing MyQueue Class
        //create some object to add
        System.out.println("<---------------Testing MyQueue class----------->");
        ObjectForTestCollections object1 = new ObjectForTestCollections(1,1.2345f,"First in MyQueue  ");
        ObjectForTestCollections object2 = new ObjectForTestCollections(2,2.4563f,"Second in  MyQueue");
        ObjectForTestCollections object3 = new ObjectForTestCollections(3,3.4567f,"Third in  ");
        ObjectForTestCollections object4 = new ObjectForTestCollections(4,4.5678f,"Forth in  ");

        MyQueue <ObjectForTestCollections> myQueue1 = new MyQueue<>();  // Queue
        myQueue1.add(object1);
        myQueue1.add(object2);
        myQueue1.add(object3);
        myQueue1.add(object4);

        System.out.println("Peek element "+ myQueue1.peek());
        System.out.println("Poll element "+ myQueue1.poll());
        System.out.println("Peek element "+ myQueue1.peek());

        System.out.println("Peek element "+ myQueue1.peek()+"size of queue "+ myQueue1.size());
        myQueue1.clear();
        System.out.println("Peek element after clear() "+ myQueue1.peek()+" size of queue "+ myQueue1.size());









// testing MyHashMap class

        MyHashMap<Integer, String> myHashMapOfIdNamePairs = new MyHashMap<>();
        //put elements to MyHashMap
        System.out.println("\n Testing MyHashMAp class\n");
        myHashMapOfIdNamePairs.put(35627,"Porshe Carrera GT");
        myHashMapOfIdNamePairs.put(67382,"Alfa Romeo Gulia");
        myHashMapOfIdNamePairs.put(72832,"VW Jetta");
        myHashMapOfIdNamePairs.put(86719,"Ford F150");
        myHashMapOfIdNamePairs.put(243,"Tesla");
        myHashMapOfIdNamePairs.put(72832,"Subaru Impreza");
        System.out.println("Size of myHashMapOfIdNamePairs:"+myHashMapOfIdNamePairs.size()); // print size
        // testing get method
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(35627));
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(72832));
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(5));
        // put element with existing key
        //print before
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(86719));
        myHashMapOfIdNamePairs.put(86719,"Mitsubishi Lancer");
        //print after
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(86719));
        System.out.println("test clear() method");
        myHashMapOfIdNamePairs.clear();

        System.out.println("Size of myHashMapOfIdNamePairs:"+myHashMapOfIdNamePairs.size()); // print size

        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(35627));
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(72832));
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(5));
        System.out.println("Get Element by key "+myHashMapOfIdNamePairs.get(86719));

    }
}

class ObjectForTestCollections{
    private final int aInt;
    private final float aFloat;
    private final String someString;

    public ObjectForTestCollections(int aInt, float aFloat, String someString) {
        this.aInt = aInt;
        this.aFloat = aFloat;
        this.someString = someString;
    }

    @Override
    public String toString() {
        return someString + "-->" + aInt +"--->" + aFloat;
    }
}