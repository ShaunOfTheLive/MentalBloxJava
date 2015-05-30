package com.shaunofthelive.MentalBlox.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.shaunofthelive.MentalBlox.models.Game;

public class GameTest {

	@Test
	public void testGame() {
		Game game = new Game();
		assertThat(game, notNullValue());
	}
	
}
