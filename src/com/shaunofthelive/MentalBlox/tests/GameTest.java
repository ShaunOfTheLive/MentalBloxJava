package com.shaunofthelive.MentalBlox.tests;

import com.shaunofthelive.MentalBlox.models.Game;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void testGame() {
        Game game = new Game();
        assertThat(game, notNullValue());
    }

}
