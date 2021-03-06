package com.shaunofthelive.MentalBlox.tests;

import com.shaunofthelive.MentalBlox.models.Die;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class DieTest {

    @Test
    public void testDie() {
        Die die = new Die(6);
        assertThat(die, notNullValue());
    }

    @Test
    public void testRoll() {
        Die die = new Die(6);
        assertThat(
                die.roll(),
                allOf(greaterThanOrEqualTo(1),
                        lessThanOrEqualTo(die.getSides())));
    }

    @Test
    public void testGetLastRoll() {
        Die die = new Die(6);
        int lastRoll = die.roll();
        assertThat(die.getLastRoll(), is(lastRoll));
    }

    @Test
    public void testGetSides() {
        Die die = new Die(6);
        assertThat(die.getSides(), is(6));
    }

    @Test
    public void testRandInt() {
        // TODO: better test for randomness
        assertThat(Die.randInt(1, 6),
                allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(6)));
    }
}
