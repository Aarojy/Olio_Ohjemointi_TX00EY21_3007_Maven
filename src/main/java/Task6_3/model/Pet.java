package Task6_3.model;

public class Pet {
    private double x;
    private double y;
    private double targetx;
    private double targety;
    private double speed = 5;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
        targetx = x;
        targety = y;
    }

    public void moveTowardsMouse() {

        double distancex = targetx - x;
        double distancey = targety - y;
        double distance = Math.sqrt(distancex * distancex + distancey * distancey);

        if (distance > 10) {
            double dx = distancex / distance;
            double dy = distancey / distance;
            x += dx * speed;
            y += dy * speed;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setTargetx(double targetx) {
        this.targetx = targetx;
    }

    public void setTargety(double targety) {
        this.targety = targety;
    }
}
