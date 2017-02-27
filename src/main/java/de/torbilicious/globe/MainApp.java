package de.torbilicious.globe;

import de.torbilicious.globe.graphics.Drawable;
import de.torbilicious.globe.line.Line;
import de.torbilicious.globe.line.LineFactory;
import processing.core.PApplet;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainApp extends PApplet {

    private ArrayList<Line> lines = new ArrayList<>();
    private Queue<Drawable> toDraw = new LinkedList<>();
    private LineFactory lineFactory;

    public static void main(String... args) {

        PApplet.main(MainApp.class);
    }

    @Override
    public void settings() {

        size(800, 600, P2D);

        lineFactory = new LineFactory(width, height);
    }

    @Override
    public void setup() {

        background(0);
        smooth();
        strokeWeight(15);

//        frameRate(120);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Line newLine = lineFactory.createRandomLine();

                lines.add(newLine);
                toDraw.add(newLine);
            }
        }, 0, 1);
    }

    @Override
    public void draw() {

        stroke(random(50), random(255), random(255), 100);

        Long startingTime = System.nanoTime();
        Long currentTime;
        Long deltaNano;
        Long deltaMilli;

        while (!toDraw.isEmpty()) {

            currentTime = System.nanoTime();
            deltaNano = currentTime - startingTime;
            deltaMilli = TimeUnit.MILLISECONDS.convert(deltaNano, TimeUnit.NANOSECONDS);
            if (deltaMilli > 10) {

                break;
            }

            stroke(random(50), random(255), random(255), 100);

            Drawable drawable = toDraw.poll();
            drawable.draw(this);

            System.out.printf("Elements remaining: %d%n", toDraw.size());
        }
    }
}
