package de.torbilicious.globe.line;

import de.torbilicious.globe.graphics.Drawable;
import processing.core.PApplet;

public class Line implements Drawable{

    private final int x1;
    private final int x2;

    private final int y1;
    private final int y2;

    Line(Integer x1,
         Integer y1,
         Integer x2,
         Integer y2) {

        this.x1 = x1;
        this.x2 = x2;

        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void draw(PApplet app) {
        app.line(x1, y1, x2, y2);
    }
}
