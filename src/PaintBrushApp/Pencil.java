/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintBrushApp;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author hayam tarek
 */
public class Pencil extends Shape {

    private ArrayList<Point> points;

    public Pencil(Color color, Point startPoint, boolean isSolid, boolean isDotted, int strokeWidth) {
        super(color, startPoint, isSolid, isDotted, strokeWidth);
        points = new ArrayList<>();
        points.add(startPoint);
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(strokeWidth));

        if (isDotted) {
            float[] dashPattern = {10, 10};
            g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dashPattern, 0));
        }
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}
