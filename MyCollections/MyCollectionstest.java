import task1.MyArrayList;
import task2.MyLinkedList;
import task3.MyHashMap;

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




    }
}

class ObjectForTestCollections{
    private int aInt;
    private float aFloat;
    private String someString;

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