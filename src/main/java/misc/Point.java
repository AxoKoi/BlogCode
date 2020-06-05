/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package misc;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distance(Point otherPoint) {
        double dx = 1.0 * (this.x - otherPoint.getX());
        double dy = 1.0 * (this.y - otherPoint.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class PointUtility {
    public static double distance(Point a, Point b) {
        double dx = 1.0 * (a.getX() - b.getX());
        double dy = 1.0 * (a.getY() - b.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }
}
