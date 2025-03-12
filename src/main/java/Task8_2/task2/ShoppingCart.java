package Task8_2.task2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();

    public void addItem(String item, double price) {
        items.add(item);
        prices.add(price);
    }

    public void removeItem(int index) {
        items.remove(index);
        prices.remove(index);
    }

    public String getItemName(int index) {
        return items.get(index);
    }

    public double getItemPrice(int index) {
        return prices.get(index);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

}
