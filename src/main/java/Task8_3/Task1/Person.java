package Task8_3.Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Create a Class: Create a class called Person with fields name (String), age (int), and city (String).
public class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public static void main(String[] args) {
        //Create a List: Create a list of Person objects with various names, ages, and cities.
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 30, "New York"));
        people.add(new Person("Mary", 23, "London"));
        people.add(new Person("Bob", 55, "Helsinki"));
        people.add(new Person("Steve", 19, "Pihtipudas"));
        people.add(new Person("Jen", 46, "Pihtipudas"));

        //Sort by Age: Use lambda expressions and the Comparator interface to sort the list of Person objects by age in ascending order.
        Comparator<Person> AgeComparator = (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge());
        people.sort(AgeComparator);

        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getCity());
        }
        System.out.println();

        //Filter by City: Use lambda expressions to filter the sorted list and keep only the people from a specific city (e.g., "New York"). Hint: removeIf().
        people.removeIf(person -> !person.getCity().equals("Pihtipudas"));

        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getCity());
        }
    }
}
