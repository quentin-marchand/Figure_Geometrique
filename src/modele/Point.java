package modele;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int rendreX() {
        return this.x;
    }

    public int rendreY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void translation(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int distance(Point p) {
        return (int) Math.sqrt(((p.rendreY() - this.rendreY()) * (p.rendreY() - this.rendreY())) + ((p.rendreX() - this.rendreX()) * (p.rendreX() - this.rendreX())));
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        if (this.x == p.x && this.y == p.y)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return super.toString() + " x : " + this.x + " y : " + this.y;
    }
}
