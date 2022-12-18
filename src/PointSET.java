import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PointSET {
    private final Set<Point2D> point2DSet;

    // construct an empty set of points
    public PointSET() {
        point2DSet = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return point2DSet.isEmpty();
    }

    // number of points in the set
    public int size() {
        return point2DSet.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        validatePoint(p);
        point2DSet.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        validatePoint(p);
        return point2DSet.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        point2DSet.forEach(Point2D::draw);
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if(null == rect){
            throw new IllegalArgumentException("RectHV object must not be null");
        }
        List<Point2D> pointsInRect = new LinkedList<>();
        for(Point2D point: point2DSet){
            if(rect.contains(point))
                pointsInRect.add(point);
        }
        return pointsInRect;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        validatePoint(p);
        Point2D nearestPoint = null;
        double minDistanceSquare = Double.POSITIVE_INFINITY;
        for(Point2D point: point2DSet){
            if(point.distanceSquaredTo(p) < minDistanceSquare){
                nearestPoint = point;
                minDistanceSquare = point.distanceSquaredTo(p);
            }
        }
        return nearestPoint;
    }

    private void validatePoint(Point2D p){
        if(null == p){
            throw new IllegalArgumentException("Point object must not be null");
        }
    }
    public static void main(String[] args) {
        PointSET pointSET = new PointSET();
        In input = new In();
        System.out.println("starting reading");
        while(input.hasNextLine()){
            double x = input.readDouble();
            double y = input.readDouble();
            Point2D point2D = new Point2D(x, y);
            pointSET.insert(point2D);
        }
        System.out.println("Reading completed");
        pointSET.draw();
        Point2D nearestPoint = pointSET.nearest(new Point2D(0.5,0.5));
        System.out.println("Nerest point: "+ nearestPoint);
        System.out.println("Done");
    }
}
