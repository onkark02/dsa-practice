package com.coursera.algo1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private Point[] points;
    private final List<LineSegment> lineSegments;
    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if(points == null){
            throw new IllegalArgumentException("Provided list is null");
        }
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            validatePoint(points[i],i);
            this.points[i] = points[i];
        }
        lineSegments = new ArrayList<>();
        Arrays.sort(this.points);
        calculateCollinearLineSegments();
    }

    private void calculateCollinearLineSegments() {
        for(int p1=0; p1 < points.length - 3; p1++){
            Point point1 = points[p1];
            //Create array of other point along with its slope with point1
            PointWithSlope[] pointsWithSlope = new PointWithSlope[points.length];
            for (int i=0; i < pointsWithSlope.length; i++){
                pointsWithSlope[i] = new PointWithSlope(points[i],point1.slopeTo(points[i]));
            }
            //Sort array as per slope
            Arrays.sort(pointsWithSlope);

            //Check if there are 3 points with same slope & add them to result lineSegment
            List<Point> collinearPoints = new ArrayList<>();
            int iterator = 0;
            while (iterator < pointsWithSlope.length){
                double currentSlope = pointsWithSlope[iterator].getSlope();
                collinearPoints.add(pointsWithSlope[iterator++].getPoint());
                while(iterator < pointsWithSlope.length && currentSlope == pointsWithSlope[iterator].getSlope()){
                    collinearPoints.add(pointsWithSlope[iterator++].getPoint());
                }
                if(collinearPoints.size() >= 3){
                    collinearPoints.add(point1);
                    addLineSegmentInResult(collinearPoints.toArray(new Point[0]),point1);
                }
                collinearPoints.clear();
            }
        }
    }

    private void addLineSegmentInResult(Point[] collinearPoints, Point startingPoint ){
        Arrays.sort(collinearPoints);
        if(startingPoint.compareTo(collinearPoints[0]) == 0){ //Add line Segment only if line is getting started from starting point
            lineSegments.add(new LineSegment(collinearPoints[0],collinearPoints[collinearPoints.length-1]));
        }
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

    private class  PointWithSlope implements Comparable<PointWithSlope>{
        Point p;
        double slope;
        public PointWithSlope(Point point, double slope){
            this.p = point;
            this.slope = slope;
        }
        public Point getPoint(){
            return this.p;
        }
        public double getSlope(){
            return this.slope;
        }

        @Override
        public int compareTo(PointWithSlope other) {
            return Double.compare(this.slope, other.slope);
        }
    }
}
