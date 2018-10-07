package com.shaunofthelive.MentalBlox.tests;

import com.shaunofthelive.MentalBlox.models.Box;
import com.shaunofthelive.MentalBlox.models.Hole;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HoleTest {
    Box box = new Box(7);

    /*
     * @Test public void testHole() { Hole hole = new Hole(3, box);
     * assertThat(hole, notNullValue()); }
     */
    @Test
    public void testIsCaptured() {
        Hole hole = box.getHole(3);
        assertThat(hole.isCaptured(), is(false));
        hole.capture(1);
        assertThat(hole.isCaptured(), is(true));
        hole.capture(0);
        assertThat(hole.isCaptured(), is(false));
    }

    @Test
    public void testGetSetOwner() {
        Hole hole = box.getHole(3);
        hole.capture(1);
        assertThat(hole.getOwner(), is(1));
    }

    @Test
    public void testGetNumber() {
        Hole hole = box.getHole(3);
        assertThat(hole.getNumber(), is(3));
        hole = box.getHole(6);
        assertThat(hole.getNumber(), is(6));
    }

    @Test
    public void testGetParentBox() {
        Hole hole = box.getHole(4);
        assertThat(hole.getParentBox(), is(box));
    }
}
