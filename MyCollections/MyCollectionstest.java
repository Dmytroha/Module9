import task1.MyArrayList;
public class MyCollectionstest {
    public static void main(String[] args) {
        // test MyArrayList class
      MyArrayList<ObjectForTestCollections> someArrLst = new MyArrayList<>();
      // test add method
      someArrLst.add(new ObjectForTestCollections(5,6.35998f,"abyrvalg"));
      someArrLst.add(new ObjectForTestCollections(789,1.00005645f,"This are magical numbers:"));
      System.out.println(someArrLst.get(1).toString()+'\n'+"size:"+someArrLst.size());
      // test remove method
      someArrLst.add(new ObjectForTestCollections(25,800f,"Third element:"));
      System.out.println(someArrLst.get(1).toString()+'\n'+"size:"+someArrLst.size());
      someArrLst.remove(1);
      System.out.println(someArrLst.get(1).toString()+'\n'+"size:"+someArrLst.size());
      //test clear method
      someArrLst.clear();
      System.out.println(someArrLst.size());
      //test exception
      ObjectForTestCollections tygydym = someArrLst.get(1);
      



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