package Task8_2.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {


    @Test
    void canGetItemName() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Milk", 2.5);

        assertEquals("Milk", cart.getItemName(0));
    }

    @Test
    void canGetItemPrice() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Milk", 2.5);

        assertEquals(2.5, cart.getItemPrice(0));
    }

    @Test
    void canAddItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Milk", 2.5);
        cart.addItem("Bread", 1.5);
        cart.addItem("Butter", 3.0);

        assertEquals(3, cart.getItemCount());

        assertEquals("Milk", cart.getItemName(0));
        assertEquals("Bread", cart.getItemName(1));
        assertEquals("Butter", cart.getItemName(2));

        assertEquals(2.5, cart.getItemPrice(0));
        assertEquals(1.5, cart.getItemPrice(1));
        assertEquals(3.0, cart.getItemPrice(2));
    }

    @Test
    void canRemoveItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Milk", 2.5);
        cart.addItem("Bread", 1.5);
        cart.addItem("Butter", 3.0);

        cart.removeItem(1);

        assertEquals(2, cart.getItemCount());

        assertEquals("Milk", cart.getItemName(0));
        assertEquals("Butter", cart.getItemName(1));

        assertEquals(2.5, cart.getItemPrice(0));
        assertEquals(3.0, cart.getItemPrice(1));
    }

    @Test
    void calculateTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Milk", 2.5);
        cart.addItem("Bread", 1.5);
        cart.addItem("Butter", 3.0);

        assertEquals(7.0, cart.calculateTotal(), 0.01);
    }

}