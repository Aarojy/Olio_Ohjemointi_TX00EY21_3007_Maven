package Task8_4.Task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 5, 8, 20, 15, 3, 12};

        int Sum = Arrays.stream(array).filter(x -> x % 2 != 0)
                                      .map(x -> x * 2)
                                      .sum();

        System.out.println("Sum: " + Sum);
    }
}
