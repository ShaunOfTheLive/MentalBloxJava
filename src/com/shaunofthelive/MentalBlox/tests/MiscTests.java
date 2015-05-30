package com.shaunofthelive.MentalBlox.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shaunofthelive.MentalBlox.models.Box;

public class MiscTests {

    @Test
    public void captureTestFiveHoles() {
        Box box = new Box(3);
        assertThat(box.isCaptured(), is(false));

        box.getHole(3).capture(1);
        assertThat(box.isCaptured(), is(false));

        box.getHole(4).capture(1);
        assertThat(box.isCaptured(), is(false));

        box.getHole(8).capture(1);
        assertThat(box.isCaptured(), is(false));

        box.getHole(9).capture(1);
        assertThat(box.isCaptured(), is(false));

        box.getHole(10).capture(1);
        assertThat(box.isCaptured(), is(true));
    }

    @Test
    public void noCaptureTestRow() {
        Box box = new Box(3);
        assertThat(box.isCaptured(), is(false));

        box.getHole(5).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(6).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(7).capture(2);
        assertThat(box.isCaptured(), is(false));
    }

    @Test
    public void captureTestRow() {
        Box box = new Box(3);
        assertThat(box.isCaptured(), is(false));

        box.getHole(6).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(7).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(8).capture(2);
        assertThat(box.isCaptured(), is(true));
    }

    @Test
    public void captureTestCol() {
        Box box = new Box(3);
        assertThat(box.isCaptured(), is(false));

        box.getHole(3).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(6).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(9).capture(2);
        assertThat(box.isCaptured(), is(true));
    }

    @Test
    public void captureTestDiag() {
        Box box = new Box(3);
        assertThat(box.isCaptured(), is(false));

        box.getHole(3).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(7).capture(2);
        assertThat(box.isCaptured(), is(false));

        box.getHole(11).capture(2);
        assertThat(box.isCaptured(), is(true));
    }

}
