package _modul;

public class _2D {

    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public _2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public _2D() {
    }

    public String show() {
        return "( " + x + " , " + y + " )";
    }
}
