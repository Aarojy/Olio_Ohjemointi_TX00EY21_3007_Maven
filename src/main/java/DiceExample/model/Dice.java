package DiceExample.model;

public class Dice {

    private int sides;

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int cast() {
        return (int) (Math.random() * sides) + 1;
    }
}
