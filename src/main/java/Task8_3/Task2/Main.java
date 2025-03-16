package Task8_3.Task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Create a List: Create a list of integers, e.g., [10, 5, 8, 20, 15, 3, 12].
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random()*100+1));
        }
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println();

        //Filter Even Numbers: Use lambda expressions to filter out even numbers from the list.
        list.removeIf(x -> x % 2 == 0);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println();

        //Double the Odd Numbers: Use lambda expressions to double the value of odd numbers in the list. Hint: replaceAll()
        list.replaceAll(x -> x*2);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println();

        //Sum the Numbers: Use lambda expressions to calculate the sum of all numbers in the list.
        final int[] sum = {0};
        list.forEach(x -> sum[0] += x);
        System.out.println("Sum of all numbers in the list: " + sum[0]);
    }
}
