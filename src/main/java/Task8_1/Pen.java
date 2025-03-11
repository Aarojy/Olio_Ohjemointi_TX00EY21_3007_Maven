package Task8_1;

public class Pen {
    private Color color;
    private Boolean capOn;

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    public Pen() {
        this.color = Color.RED;
        this.capOn = true;
    }

    public Pen(Color color) {
        this.color = color;
        this.capOn = true;
    }

    public String draw() {
        if (!capOn) {
            return "Drawing " + color.toString();
        }
        return "";
    }

    public void capOff() {
        capOn = false;
    }

    public void capOn() {
        capOn = true;
    }

    public void changeColor(Color color) {
        if (capOn) {
            this.color = color;
        }
    }
}