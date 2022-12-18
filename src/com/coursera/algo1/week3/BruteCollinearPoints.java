package com.coursera.algo1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final Point[] points;
    private final List<LineSegment> lineSegments;
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if(points == null){
            throw new IllegalArgumentException("Provided list is null");
        }
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            validatePoint(points[i],i);
            this.points[i] = points[i];
        }
        lineSegments = new ArrayList<>();
        calculateCollinearLineSegments();
    }

    private void calculateCollinearLineSegments() {
        for(int p1=0; p1 < points.length; p1++){
            Point point1 = points[p1];
            for(int p2=p1+1; p2 < points.length; p2++){
                Point point2 = points[p2];
                double slopeP12 = point1.slopeTo(point2);
                for(int p3=p2+1; p3 < points.length; p3++){
                    Point point3 = points[p3];
                    double slopeP13 = point1.slopeTo(point3);
                    if(Math.abs(slopeP12) != Math.abs(slopeP13)){
                        //Since 3 points are not co linear, no need to check for 4 th point
                        continue;
                    }
                    for(int p4=p3+1; p4 < points.length; p4++){
                        Point point4 = points[p4];
                        double slope14 = point1.slopeTo(point4);
                        if(Math.abs(slopeP12) == Math.abs(slope14)){
                            //All 4 points are colinear, this is a line segment.
                            //Need to add this in lineSegments
                            addLineSegmentInResult(point1,point2,point3,point4);
                        }
                    }
                }
            }
        }
    }

    private void addLineSegmentInResult(Point p1,Point p2, Point p3, Point p4){
        Point[] linearPoints = new Point[4];
        linearPoints[0] = p1;
        linearPoints[1] = p2;
        linearPoints[2] = p3;
        linearPoints[3] = p4;
        Arrays.sort(linearPoints);
        lineSegments.add(new LineSegment(linearPoints[0],linearPoints[3]));
    }
    private void validatePoint(Point point, int i){
        if(point == null || ifAlreadyExists(point, i))
            throw new IllegalArgumentException("Point is null or repeated");
    }
    private boolean ifAlreadyExists(Point point, int i){
        for (int j = 0; j < i; j++) {
            if(this.points[j].compareTo(point) == 0)
                return true;
        }
        return false;
    }
    // the number of line segments
    public int numberOfSegments() {
        return this.lineSegments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[0]);
    }


}
