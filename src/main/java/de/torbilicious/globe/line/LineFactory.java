package de.torbilicious.globe.line;

import java.util.concurrent.ThreadLocalRandom;

public class LineFactory {

    private Integer width;
    private Integer height;

    public LineFactory(Integer width, Integer height) {

        this.width = width;
        this.height = height;
    }

    public Line createRandomLine() {

        Integer x1 = rand(0, width);
        Integer y1 = rand(0, height);

        Integer x2 = rand(0, width);
        Integer y2 = rand(0, height);

        return new Line(x1, y1, x2, y2);
    }


    private Integer rand(Integer min, Integer max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
