import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.LinkedList;
import java.util.List;

public class KdTree {
    private Node2D tree2D;
    private int size;
    // construct an empty set of points
    public KdTree() {
        tree2D = null;
        size = 0;
    }

    // is the set empty?
    public boolean isEmpty() {
        return null == tree2D;
    }

    // number of points in the set
    public int size() {
        return this.size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        validatePoint(p);
        if (isEmpty()){
            Node2D node2D =  new Node2D(p);
            node2D.level = 0;
            tree2D = node2D;
            size += 1;
        }else{
            addNode2D(tree2D, p);
        }

    }

    private void addNode2D(Node2D nodePtr, Point2D point2D){
        Node2D node2D=  new Node2D(point2D);
        node2D.level = nodePtr.level + 1;

        Point2D ptrPoint = nodePtr.point2D;
        if(ptrPoint.compareTo(point2D) == 0){
            //Point is already present no need to add new
            return;
        }
        if(nodePtr.level % 2 == 0){
            if(point2D.x() <= ptrPoint.x()){
                if( null == nodePtr.left ) {
                    nodePtr.left = node2D;
                    size += 1;
                }
                else
                    addNode2D(nodePtr.left, point2D);
            }else{
                if( null == nodePtr.right ){
                    nodePtr.right = node2D;
                    size += 1;
                }
                else
                    addNode2D(nodePtr.right, point2D);
            }
        }else{
            if(point2D.y() <= ptrPoint.y()){
                if( null == nodePtr.left ){
                    nodePtr.left = node2D;
                    size += 1;
                }
                else
                    addNode2D(nodePtr.left, point2D);
            }else{
                if( null == nodePtr.right ){
                    nodePtr.right = node2D;
                    size += 1;
                }
                else
                    addNode2D(nodePtr.right, point2D);
            }
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        validatePoint(p);
        return contains(tree2D, p);
    }

    private boolean contains(Node2D node2D, Point2D p){
        if(node2D == null){
            return false;
        }

        Point2D point2D = node2D.point2D;
        if(point2D.compareTo(p) == 0){
            return true;
        }else {
            if(node2D.level % 2 == 0){
                if(p.x() <= point2D.x())
                    return contains(node2D.left, p);
                else
                    return contains(node2D.right, p);
            }else{
                if(p.y() <= point2D.y())
                    return contains(node2D.left, p);
                else
                    return contains(node2D.right, p);
            }
        }
    }

    // draw all points to standard draw
    public void draw() {
        traverseAndDraw2DTree(tree2D);
    }

    private void traverseAndDraw2DTree(Node2D node2D) {
        if(node2D == null){
            return;
        }
        traverseAndDraw2DTree(node2D.left);
        Point2D point2D = node2D.point2D;
        point2D.draw();
        traverseAndDraw2DTree(node2D.right);
    }


    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if(null == rect){
            throw new IllegalArgumentException("RectHV object must not be null");
        }
        List<Point2D> pointsInRect = new LinkedList<>();

        return pointsInRect;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        validatePoint(p);
        Point2D nearestPoint = null;
        Double minDistanceSquare = Double.POSITIVE_INFINITY;
        return nearestPoint(tree2D, minDistanceSquare, p);
    }

    private Point2D nearestPoint(Node2D node2D, Double minDistanceSquare, Point2D p){
        if(node2D == null){
            return null;
        }
        Point2D point2D = node2D.point2D;
        Double distanceSquareFromNode = point2D.distanceSquaredTo(p);
        boolean left;
        if(node2D.level % 2 == 0){
            left = p.x() <= point2D.x();
        }else{
            left = p.y() <= point2D.y();
        }

        Point2D nearestPoint;
        //Check nearest point for subtree which is should be closer to point
        if(left){
            nearestPoint = nearestPoint(node2D.left, minDistanceSquare, p);
        }else{
            nearestPoint = nearestPoint(node2D.right, minDistanceSquare, p);
        }

        //If current node is nearest till now, check for other subtree as well
        if(nearestPoint == null || distanceSquareFromNode <= minDistanceSquare){
            if(left){
                nearestPoint = nearestPoint(node2D.right, minDistanceSquare, p);
            }else{
                nearestPoint = nearestPoint(node2D.left, minDistanceSquare, p);
            }
        }
        //If current node is nearest till now
        if(nearestPoint == null || distanceSquareFromNode <= minDistanceSquare)
            nearestPoint = point2D;

        return nearestPoint;
    }

    private void validatePoint(Point2D p){
        if(null == p){
            throw new IllegalArgumentException("Point object must not be null");
        }
    }

    private class Node2D{
        Point2D point2D;
        Node2D left;
        Node2D right;
        int level;

        Node2D(Point2D point2D){
            this.point2D = point2D;
        }
    }

    public static void main(String[] args) {
        KdTree kdTree = new KdTree();
        In input = new In();
        System.out.println("starting reading");
        while(input.hasNextLine()){
            double x = input.readDouble();
            double y = input.readDouble();
            Point2D point2D = new Point2D(x, y);
            kdTree.insert(point2D);
        }
        System.out.println("Reading completed");
        kdTree.draw();
        Point2D nearestPoint = kdTree.nearest(new Point2D(0.5,0.5));
        System.out.println("Nerest point: "+ nearestPoint);
        System.out.println("Done");
    }
}
