import java.util.Comparator;

public class Dog {
    private String name;
    private int size;

    Dog(String name_ ,int size_)
    {
        name=name_;
        size=size_;
    }

    public void bark()
    {
        System.out.println(name+" bark!");
    }

    private class NameCompareMachine  implements Comparator<Dog>
    {
        @Override
        public int compare(Dog d1,Dog d2)
        {
            return d1.name.compareTo(d2.name);
        }
    }


}
