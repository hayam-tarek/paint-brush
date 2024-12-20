/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintBrushApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;

/**
 *
 * @author hayam tarek
 */
public class Eraser extends Shape {

    private ArrayList<Point> erasePoints;
    private int radius;

    public Eraser(Color color, Point startPoint, boolean isSolid, boolean isDotted, int strokeWidth) {
        super(color, startPoint, isSolid, isDotted, strokeWidth);
        this.erasePoints = new ArrayList<>();
        this.radius = strokeWidth > 5 ? strokeWidth : 5;
    }

    public void addErasePoint(Point point) {
        erasePoints.add(point);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
//        g.setStroke(new BasicStroke(strokeWidth));
        for (Point p : erasePoints) {
            g.fillOval(p.x - radius / 2, p.y - radius / 2, radius, radius);
        }
    }

}
