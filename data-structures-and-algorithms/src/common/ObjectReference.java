package common;

public class ObjectReference {
    private String data;

    public ObjectReference(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        ObjectReference object1 = new ObjectReference("first");
        System.out.println(object1);
        System.out.println(object1.data);

        ObjectReference object2 = object1;
        System.out.println(object2);
        System.out.println(object2.data);
        object2.data = "second";

        System.out.println(object1.data);
        System.out.println(object2.data);

        // true because both variables store the same reference.
        System.out.println(object1 == object2);
    }
}
