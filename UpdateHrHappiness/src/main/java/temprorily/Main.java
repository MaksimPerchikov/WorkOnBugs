package temprorily;

public class Main {

    public static void main(String[] args) {

        Person p = new Person();

        Person p1 = p;

        p.age = 100;
        p1.age = 10;

        System.out.println(p.age);
    }

}

class Person{
    public int age;
}