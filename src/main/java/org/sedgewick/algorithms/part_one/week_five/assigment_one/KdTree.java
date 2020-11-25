package org.sedgewick.algorithms.part_one.week_five.assigment_one;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class KdTree {
    private Node root;
    private int size;

    public KdTree() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Point2D p) {
        validate(p);
        if (root == null) {
            root = new Node(null, null, p,
                    new RectHV(0, 0, 1, 1));
            size++;
            return;
        }
        insertPoint(root, p, true);
    }

    private Node insertPoint(Node root, Point2D point, boolean isX) {
        if (root == null) {
            size++;
            return new Node(point);
        }
        if (point.equals(root.val)) return root;

        int comp = isX
                ? Double.compare(point.x(), root.val.x())
                : Double.compare(point.y(), root.val.y());

        if (comp < 0) {
            root.left = insertPoint(root.left, point, !isX);
            if (root.left.rect == null)
                root.left.rect = new RectHV(
                        root.rect.xmin(),
                        root.rect.ymin(),
                        isX ? root.val.x() : root.rect.xmax(),
                        !isX ? root.val.y() : root.rect.ymax()
                );
        } else {
            root.right = insertPoint(root.right, point, !isX);
            if (root.right.rect == null)
                root.right.rect = new RectHV(
                        isX ? root.val.x() : root.rect.xmin(),
                        !isX ? root.val.y() : root.rect.ymin(),
                        root.rect.xmax(),
                        root.rect.ymax()
                );
        }

        return root;
    }

    public boolean contains(Point2D p) {
        validate(p);

        if (root == null) return false;
        if (root.val.equals(p)) return true;

        Node node = root;
        boolean isX = true;
        while (node != null) {
            if (p.equals(node.val)) return true;

            int comp = isX
                    ? Double.compare(p.x(), node.val.x())
                    : Double.compare(p.y(), node.val.y());

            if (comp < 0) node = node.left;
            else node = node.right;
            isX = !isX;
        }
        return false;
    }


    public void draw() {
        draw(root, true);
    }

    private void draw(Node node, boolean isX) {
        if (node == null) return;

        StdDraw.setPenRadius();
        if (isX) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(
                    node.val.x(),
                    node.rect.ymin(),
                    node.val.x(),
                    node.rect.ymax()
            );
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(
                    node.rect.xmin(),
                    node.val.y(),
                    node.rect.xmax(),
                    node.val.y()
            );
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        node.val.draw();

        draw(node.left, !isX);
        draw(node.right, !isX);
    }

    public Iterable<Point2D> range(RectHV rect) {
        validate(rect);
        List<Point2D> result = new ArrayList<>();
        if (root != null) range(root, rect, result);
        return result;
    }

    private void range(Node node, RectHV rect, List<Point2D> list) {
        if (rect.contains(node.val)) list.add(node.val);
        if (node == null) return;

        if (node.left != null && rect.intersects(node.left.rect)) range(node.left, rect, list);
        if (node.right != null && rect.intersects(node.right.rect)) range(node.right, rect, list);
    }

    public Point2D nearest(Point2D p) {
        validate(p);
        if (size == 0) return null;
        return nearest(root, p, Double.MAX_VALUE);
    }

    private Point2D nearest(Node node, Point2D p, double min) {
        Point2D result = null;
        double distance = node.val.distanceSquaredTo(p);

        if (distance < min) {
            min = distance;
            result = node.val;
        }

        if (node.left != null && node.right != null) {
            double leftDistance = node.left.rect.distanceSquaredTo(p);
            double rightDistance = node.right.rect.distanceSquaredTo(p);

            if (leftDistance < rightDistance) {
                Point2D nearestLeft = nearest(node.left, p, min);
                if (nearestLeft != null) {
                    result = nearestLeft;
                    min = nearestLeft.distanceSquaredTo(p);
                }

                if (rightDistance < min) {
                    Point2D nearestRight = nearest(node.right, p, min);
                    if (nearestRight != null) result = nearestRight;
                }
            } else {
                Point2D nearestRight = nearest(node.right, p, min);
                if (nearestRight != null) {
                    result = nearestRight;
                    min = nearestRight.distanceSquaredTo(p);
                }

                if (leftDistance <  min) {
                    Point2D nearestLeft = nearest(node.left, p, min);
                    if (nearestLeft != null) result = nearestLeft;
                }
            }
        } else if (node.left != null || node.right != null) {
            Node child = node.left != null ? node.left : node.right;

            if (child.rect.distanceSquaredTo(p) < min) {
                Point2D nearest = nearest(child, p, min);
                if (nearest != null) result = nearest;
            }
        }

        return result;
    }

    private void validate(Object o) {
        if (o == null)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

    }

    private class Node {
        Node left;
        Node right;
        Point2D val;
        RectHV rect;

        public Node(Point2D val) {
            this.val = val;
        }

        public Node(Node left, Node right, Point2D val, RectHV rect) {
            this.left = left;
            this.right = right;
            this.val = val;
            this.rect = rect;
        }
    }
}
