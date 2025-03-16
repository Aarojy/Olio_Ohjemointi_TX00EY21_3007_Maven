package Task8_4.Task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 5, 8, 20, 15, 3, 12};

        double mean = Arrays.stream(array).average().orElse(Double.NaN);

        System.out.println("Mean: " + mean);
    }
}
