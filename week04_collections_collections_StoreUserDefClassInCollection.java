package collections;
import java.util.ArrayList;
import java.util.Iterator;
class CollectionClass
{
    ArrayList<UserDefindClass> arrayList;
    CollectionClass(UserDefindClass userDefindClass1,UserDefindClass userDefindClass2,UserDefindClass userDefindClass3
            ,UserDefindClass userDefindClass4)
    {
        arrayList = new ArrayList<>();
        arrayList.add(userDefindClass1); //Object object
        arrayList.add(userDefindClass2);//Object object
        arrayList.add(userDefindClass3);//Object object
        arrayList.add(userDefindClass4);//Object object
    }

    void displayElements() {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
        {
            Object object = iterator.next();
            UserDefindClass userDefindClass = (UserDefindClass) object;
            System.out.println("UserDefinedObjects are -> "+userDefindClass.toString());
        }
    }
}

class UserDefindClass
{
    String userDefindClassObjName;
    UserDefindClass(String userDefindClassObjName)
    {
        this.userDefindClassObjName=userDefindClassObjName;
    }
    @Override
    public String toString() {
        return userDefindClassObjName;
    }
}
public class StoreUserDefClassInCollection {
      public static void main(String...args) {
          UserDefindClass userDefindClass1 = new UserDefindClass("userDefindClass1");
          UserDefindClass userDefindClass2 = new UserDefindClass("userDefindClass2");
          UserDefindClass userDefindClass3 = new UserDefindClass("userDefindClass3");
          UserDefindClass userDefindClass4 = new UserDefindClass("userDefindClass4");

          CollectionClass collectionClass = new CollectionClass(userDefindClass1,userDefindClass2,userDefindClass3
          ,userDefindClass4);
                collectionClass.displayElements();

          }
}
