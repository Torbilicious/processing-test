package de.torbilicious.globe;

import processing.core.PApplet;

import java.util.ArrayList;

class Line {

    final int x1;
    final int x2;

    final int y1;
    final int y2;

    Line(Integer x1,
         Integer y1,
         Integer x2,
         Integer y2) {

        this.x1 = x1;
        this.x2 = x2;

        this.y1 = y1;
        this.y2 = y2;
    }
}

public class MainApp extends PApplet {

    private ArrayList<Line> lines = new ArrayList<>();

    public static void main(String[] args) {

        PApplet.main(MainApp.class);
    }

    @Override
    public void settings() {

        size(800, 600, FX2D);
    }

    @Override
    public void setup() {

        background(0);
        smooth();
        strokeWeight(15);
//        frameRate(120);
    }

    @Override
    public void draw() {

        stroke(random(50), random(255), random(255), 100);

        for(Line line : lines) {

            line(line.x1, line.y1, line.x2, line.y2);
        }


//        line(x, 0, random(0, width), height);
//        x = x < width ? x+1 : 0;
    }

//    private Line getRandomLine() {
//
//        return new Line();
//    }
}
