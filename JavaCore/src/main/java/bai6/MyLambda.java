package bai6;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Hello {
    public String sayHello(String name, String com);
}
public class MyLambda {
//    public static void main(String[] args) {
//        Hello s = (name, com) -> "Hello, " + name + ". Welcome to " + com;
//        System.out.println(s.sayHello("newbie", "Lambda"));
//    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 40));
        people.add(new Person("Eve", 45));
        // sort descending by age
        people.sort((p1, p2) -> p2.getAge() - p1.getAge());
        // print the names and ages of sorted people
        people.forEach(p -> System.out.println(p.getName() + ": " + p.getAge()));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}