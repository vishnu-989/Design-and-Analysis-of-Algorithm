import java.util.Arrays;
import java.util.Comparator;

public class Exp15_ClosestPairOfPoints {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static double bruteForce(Point[] points, int left, int right, Point[] closestPair) {
        double minDist = Double.MAX_VALUE;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j < right; j++) {
                double d = dist(points[i], points[j]);
                if (d < minDist) {
                    minDist = d;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        Point[] points = {
            new Point(1, 2),
            new Point(4, 5),
            new Point(7, 8),
            new Point(3, 1)
        };

        Arrays.sort(points, Comparator.comparingInt(p -> p.x));

        Point[] closestPair = new Point[2];
        double minDist = bruteForce(points, 0, points.length, closestPair);

        System.out.println("Closest pair: (" + closestPair[0].x + "," + closestPair[0].y + ")-("
                + closestPair[1].x + "," + closestPair[1].y + ")");
        System.out.println("Distance = " + minDist);
    }
}
